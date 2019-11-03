package com.example.subdicoding;

import android.view.View;

public class CustomOnitemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallBack itemClickCallBack;

    public CustomOnitemClickListener(int position, OnItemClickCallBack itemClickCallback){
        this.position = position;
        this.itemClickCallBack = itemClickCallback;
    }
    @Override
    public void onClick(View view) {
        itemClickCallBack.DataClick(view,position);
    }
    public interface OnItemClickCallBack{
        void DataClick(View view, int position);
    }
}
