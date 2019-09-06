package com.example.hp.pizzahut_order;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class searchresult extends AppCompatActivity {

    GridView gridView;
    String[] pizzanames = {"Cheese Lover","Veggie Supreme","Spicy Veggie Panner","Devilled Chicken","Chicken Bacon"};
    int[] pizzaimage = {R.drawable.cheeselover,R.drawable.veggiesupreme,R.drawable.spicyveggiepanner,R.drawable.devilledchicken,R.drawable.chickenbacon};

//    private RecyclerView recyclerView;
//    private int[] images = {R.drawable.chickenbacon, R.drawable.cheeselover,R.drawable.devilledchicken, R.drawable.spicyveggiepanner,R.drawable.veggiesupreme};
//
//
//    private RecyclerAdapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpizzatext);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(),griditem.class);
                intent.putExtra("name",pizzanames[i]);
                intent.putExtra("image",pizzaimage[i]);
                startActivity(intent);

            }
        });


    }
    private class CustomAdapter extends BaseAdapter{



            @Override
            public int getCount() {
                return pizzaimage.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.activity_rowdata,null);

                TextView name = view.findViewById(R.id.chesse);
                ImageView imageView = view.findViewById(R.id.cheesseimage);

                name.setText(pizzanames[i]);
                imageView.setImageResource(pizzaimage[i]);
                return  view;
            }
        }

//        recyclerView = findViewById(R.id.recyclerView);
//        layoutManager = new GridLayoutManager(this,1);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new RecyclerAdapter(images);
//        recyclerView.setAdapter(adapter);
//

}
