package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Joshua Evan Arijanto on 7/29/2019.
 */

public class GridDreamAdapter extends RecyclerView.Adapter<GridDreamAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Dream> listDream;

    public ArrayList<Dream> getListDream(){
        return listDream;
    }

    public void setListDream(ArrayList<Dream> listDream){
        this.listDream = listDream;
    }

    public GridDreamAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
.inflate(R.layout.item_grid_dream,parent,false);
        GridViewHolder gridViewHolder  = new GridViewHolder(view);

        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListDream().get(position).getPhoto())
                .override(350,550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDream().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        public GridViewHolder(View itemView){
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
