package com.brittle.brittle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brittle.brittle.R;
import com.brittle.brittle.model.GroceryItem;

import java.util.ArrayList;

public class TokenAdapter extends RecyclerView.Adapter<TokenAdapter.ViewHolder> {

    ArrayList<GroceryItem> groceryItems;


    public TokenAdapter(@NonNull ArrayList<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GroceryItem token = groceryItems.get(position);

        holder.tvItemName.setText(token.getItemName());
        holder.tvItemPrice.setText(String.valueOf(token.getItemPrice()));
        holder.tvItemQuantity.setText(token.getItemQuantity());
        holder.tvRemainingData.setText(token.getRemainingData());
    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivItemImage;
        private TextView tvItemName, tvItemPrice, tvItemQuantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItemImage = itemView.findViewById(R.id.ivItemImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvItemQuantity = itemView.findViewById(R.id.tvItemQuantity);
        }
    }
}
