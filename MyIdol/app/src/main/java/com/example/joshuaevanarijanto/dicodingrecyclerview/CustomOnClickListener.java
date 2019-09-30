package com.example.joshuaevanarijanto.dicodingrecyclerview;

import android.media.ImageReader;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Joshua Evan Arijanto on 7/29/2019.
 */

public class CustomOnClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnClickListener(int position, OnItemClickCallback onItemCLickCallback){
        this.position = position;
        this.onItemClickCallback = onItemCLickCallback;

    }

    @Override
    public void onClick(View v) {
        onItemClickCallback.onItemClicked(v, position);
    }

    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }

}
