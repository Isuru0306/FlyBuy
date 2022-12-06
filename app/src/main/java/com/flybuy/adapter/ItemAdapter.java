package com.flybuy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.flybuy.ItemDetails;
import com.flybuy.R;
import com.flybuy.controllers.ItemController;
import com.flybuy.model.ItemData;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    List<ItemData> itemDataList;

    public ItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);

        // here we create a recyclerview row item layout file
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.rating.setText(itemDataList.get(position).getRating());
        holder.placeName.setText(itemDataList.get(position).getPlaceName());
        holder.placeImage.setImageResource(itemDataList.get(position).getImageUrl());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, ItemDetails.class);
                new ItemController(context, position, i, itemDataList);

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, rating;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.hotelImage);
            placeName = itemView.findViewById(R.id.itemName);
            rating = itemView.findViewById(R.id.ratings);


        }
    }
}
