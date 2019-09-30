package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Joshua Evan Arijanto on 7/29/2019.
 */

public class CardViewDreamAdapter extends RecyclerView.Adapter
        <CardViewDreamAdapter.CardViewViewHolder> {

    private ArrayList<Dream> listDream;
    private Context context;

    public CardViewDreamAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Dream> getListDream(){
        return listDream;
    }

    public void setListDream (ArrayList<Dream> listDream){
        this.listDream = listDream;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_dream,parent,false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        Dream d = getListDream().get(position);

        Glide.with(context)
                .load(d.getPhoto())
                .override(350,550)
                .into(holder.imgPhoto);

        holder.tvName.setText(d.getName());
        holder.tvRemarks.setText(d.getRemarks());

        holder.btnFav.setOnClickListener(new CustomOnClickListener(position,
                new CustomOnClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        Toast.makeText(context,
                                "Favourite" + getListDream().get(position)
                        .getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                }){

        });

        holder.btnShare.setOnClickListener(new CustomOnClickListener(position,
                new CustomOnClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        Toast.makeText(context,
                                "Share" + getListDream().get(position)
                                        .getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                }){

        });
    }

    @Override
    public int getItemCount() {
        return getListDream().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFav, btnShare;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFav = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }

}
