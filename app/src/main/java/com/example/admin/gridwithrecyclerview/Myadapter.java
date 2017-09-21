package com.example.admin.gridwithrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.gridwithrecyclerview.Datas;
import com.example.admin.gridwithrecyclerview.R;

import java.util.List;

/**
 * Created by Admin on 9/21/2017.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    View row;
    List<Datas> data;

    public Myadapter(Context context, List<Datas> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(context).inflate(R.layout.listitem, null, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Datas datas = data.get(position);
        ((Item) holder).m1.setImageURI(Uri.parse(datas.imageid));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class Item extends RecyclerView.ViewHolder {
        ImageView m1;

        public Item(View itemView) {
            super(itemView);
            m1 = (ImageView) itemView.findViewById(R.id.m1);

        }

    }
}
