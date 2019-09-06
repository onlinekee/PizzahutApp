package com.example.hp.pizzahut_order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements Filterable {
    Context c;
    ArrayList<Pizza> pizzas;
    ArrayList<Pizza> filterList;
    CustomFilter filter;

    public Adapter(Context c, ArrayList<Pizza> pizzas) {
        this.c = c;
        this.pizzas = pizzas;
        this.filterList = pizzas;
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
        return pizzas.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView== null){
            convertView = inflater.inflate(R.layout.activity_griditem,null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.chesse);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.cheesseimage);

        name.setText(pizzas.get(position).getName());
        imageView.setImageResource(pizzas.get(position).getImg());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length() > 0){
                //constraint to upper
                constraint = constraint.toString().toUpperCase();

                ArrayList< Pizza> filters =new  ArrayList<Pizza>();

                //filtering

                for (int i =0;i<filterList.size();i++){
                    if(filterList.get(i).getName().toUpperCase().contains(constraint)){

                        Pizza pizza = new Pizza(filterList.get(i).getVariety(),filterList.get(i).getType(),filterList.get(i).getName(), filterList.get(i).getImg());
                        filters.add(pizza);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                pizzas = (ArrayList<Pizza>)results.values;
                notifyDataSetChanged();
        }
    }
}
