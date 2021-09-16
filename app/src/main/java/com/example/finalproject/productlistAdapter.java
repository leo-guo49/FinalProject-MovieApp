package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class productlistAdapter extends ArrayAdapter<product> {
    private static final String TAG = "productlistAdapter";
    private Context mContext;
    int mResource;

    public productlistAdapter(Context context, int resource, ArrayList<product> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        String name = getItem(position).getName();
        String platform = getItem(position).getPlatform();
        int img = getItem(position).getImg();

        //product pro = new product(name, platform);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvName = (TextView)convertView.findViewById(R.id.name);
        TextView tvPlatform = (TextView)convertView.findViewById(R.id.platform);
        ImageView tvImg = (ImageView)convertView.findViewById(R.id.image);
        tvName.setText(name);
        tvPlatform.setText(platform);
        tvImg.setImageResource(img);

        return convertView;
    }
}
