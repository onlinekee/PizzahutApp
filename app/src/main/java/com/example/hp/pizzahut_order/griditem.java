package com.example.hp.pizzahut_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class griditem extends AppCompatActivity {
    TextView name;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griditem);

        name = findViewById(R.id.chesse);
        imageView = findViewById(R.id.cheesseimage);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        imageView.setImageResource(intent.getIntExtra("image",0));

    }
}
