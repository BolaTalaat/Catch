package com.example.corsatk.adapters;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corsatk.controller.Item;
import com.example.corsatk.R;

import java.util.List;

/**
 * Created by bola on 5/26/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<Item> mItems;
    private GridLayoutManager mLayoutManager;

    public ItemAdapter(List<Item> items, GridLayoutManager layoutManager) {
        mItems = items;
        mLayoutManager = layoutManager;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        int spanCount = mLayoutManager.getSpanCount();

        if (spanCount == 1) {
            holder.layoutBig.setVisibility(View.VISIBLE);
            holder.layoutSmall.setVisibility(View.GONE);
        } else {
            holder.layoutSmall.setVisibility(View.VISIBLE);
            holder.layoutBig.setVisibility(View.GONE);
        }

        Item item = mItems.get(position % 6);
        holder.titleSmall.setText(item.getTitle());
        holder.titleBig.setText(item.getTitle());
        holder.ivSmall.setImageResource(item.getImgResId());
        holder.ivBig.setImageResource(item.getImgResId());
        holder.info.setText(item.getjobs());
        holder.phoneNumer.setText(item.getPhoneNumer());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        View layoutSmall;
        ImageView ivSmall;
        TextView titleSmall;
        View layoutBig;
        ImageView ivBig;
        TextView titleBig;
        TextView info;
        TextView phoneNumer;

        ItemViewHolder(View itemView) {
            super(itemView);
            layoutSmall = itemView.findViewById(R.id.layout_small);
            ivSmall = (ImageView) itemView.findViewById(R.id.image_small);
            titleSmall = (TextView) itemView.findViewById(R.id.title_small);
            layoutBig = itemView.findViewById(R.id.layout_big);
            ivBig = (ImageView) itemView.findViewById(R.id.image_big);
            titleBig = (TextView) itemView.findViewById(R.id.title_big);
            info = (TextView) itemView.findViewById(R.id.tv_info);
            phoneNumer= (TextView) itemView.findViewById(R.id.phone_info);
        }
    }
}
