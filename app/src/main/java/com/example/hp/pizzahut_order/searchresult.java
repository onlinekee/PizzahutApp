package com.example.hp.pizzahut_order;

import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class searchresult extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images = {R.drawable.chickenbacon, R.drawable.cheeselover,R.drawable.devilledchicken, R.drawable.spicyveggiepanner,R.drawable.veggiesupreme};


    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images);
        recyclerView.setAdapter(adapter);

    }
}
