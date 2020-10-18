package com.example.picturematchinggame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PictureAdapter extends BaseAdapter {

    private Context context;

    public PictureAdapter(Context context){
        this.context = context;
    }

    public int getCount(){
        return 12;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imgView;
        if(convertView == null)
        {
            imgView = new ImageView(this.context);
            imgView.setLayoutParams(new GridView.LayoutParams(300,270));
            imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else

                imgView = (ImageView)convertView;
                imgView.setImageResource(R.drawable.questionmark);

        return imgView;
    }
}
