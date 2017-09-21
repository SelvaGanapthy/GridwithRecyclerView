package com.example.admin.gridwithrecyclerview;

/**
 * Created by Admin on 9/21/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Datas> id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = new ArrayList<>();
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        dataload();
    }

    public void dataload() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray heroArray = obj.getJSONArray("actors");
                    for (int i = 0; i < heroArray.length(); i++) {
                        JSONObject heroObject = heroArray.getJSONObject(i);
                        Datas data = new Datas(heroObject.getString("image"));
                        id.add(data);
                    }
                    recyclerView.setAdapter(new Myadapter(MainActivity.this, id));

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), " " + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
