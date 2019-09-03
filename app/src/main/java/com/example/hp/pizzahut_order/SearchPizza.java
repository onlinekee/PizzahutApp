package com.example.hp.pizzahut_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchPizza extends AppCompatActivity {
    Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pizza);
        btnsearch = (Button)findViewById(R.id.button_searchpizza);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchPizza.this,searchresult.class);
                startActivity(intent);
            }
        });

    }
}
