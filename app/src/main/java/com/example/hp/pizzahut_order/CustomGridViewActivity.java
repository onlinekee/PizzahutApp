package com.example.hp.pizzahut_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGridViewActivity extends BaseAdapter {


    Context context;
    ArrayList<Pizza> pizzas;

   // private final String[] gridViewString;
    //private final int[] gridViewImageId;

    public CustomGridViewActivity(Context context, ArrayList<Pizza> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_gridview, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.gridview_image);
        TextView text = (TextView) convertView.findViewById(R.id.gridview_text);

        image.setImageResource(pizzas.get(position).getImg());
        text.setText(pizzas.get(position).getName());



        return convertView;
    }
}
