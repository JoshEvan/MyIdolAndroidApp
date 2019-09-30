package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Joshua Evan Arijanto on 7/29/2019.
 */

public class ListDreamAdapter extends RecyclerView.Adapter<ListDreamAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Dream> listDream;

    public ArrayList<Dream> getListDream(){
        return listDream;
    }

    public void setListDream(ArrayList<Dream> listDream){
        this.listDream = listDream;
    }

    public ListDreamAdapter(Context context){
        this.context = context;
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_dream,parent, false);

        return new CategoryViewHolder(itemRow);

    }

    @Override
    public void onBindViewHolder(ListDreamAdapter.CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListDream().get(position).getName());
        holder.tvRemarks.setText(getListDream().get(position).getRemarks());

        Glide.with(context)
                .load(getListDream().get(position).getPhoto())
                .override(55,55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDream().size();
    }

    class CategoryViewHolder  extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView){
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }

    }
}
