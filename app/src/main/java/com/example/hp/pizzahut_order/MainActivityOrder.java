package com.example.hp.pizzahut_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityOrder extends AppCompatActivity {
    Button btnchoosepizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);
        btnchoosepizza = (Button)findViewById(R.id.button_chhosepizza);
        btnchoosepizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityOrder.this,SearchPizza.class);
                startActivity(intent);
            }
        });
    }
}
