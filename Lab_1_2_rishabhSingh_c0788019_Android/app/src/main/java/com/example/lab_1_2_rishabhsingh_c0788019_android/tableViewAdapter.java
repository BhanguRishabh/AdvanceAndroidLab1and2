package com.example.lab_1_2_rishabhsingh_c0788019_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class tableViewAdapter extends BaseAdapter {
    List<productsModelClass> data=new ArrayList<>();
    LayoutInflater inflater;//we will need this to link with the list_row xml file

    //constructor
    public tableViewAdapter(Context context, List<productsModelClass>data)
    {
        this.data=data;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.layout,null);
            holder=new ViewHolder();
            holder.productName=view.findViewById(R.id.tvName);
            holder.productID=view.findViewById(R.id.tvId);
            holder.productPrice=view.findViewById(R.id.tvPrice);
            view.setTag(holder);

        }else
            holder = (ViewHolder) view.getTag();
        holder.productName.setText(data.get(i).getName());
        holder.productPrice.setText(String.valueOf(data.get(i).getPrice()));
        holder.productID.setText(String.valueOf(data.get(i).getId()));




        return view;
    }
    static class ViewHolder{
        private TextView productName;
        private TextView productPrice;
        private TextView productID;

    }
}

