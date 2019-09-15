package com.example.hp.pizzahut_order;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class searchresult extends AppCompatActivity {
    Spinner size,crust;
    Button paynow;
    Animation animShake;
    Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        
        size = (Spinner)findViewById(R.id.spinner_selectsize);
        crust = (Spinner)findViewById(R.id.spinner_selectcrust);
        paynow = (Button)findViewById(R.id.button_paynow);
        animShake =AnimationUtils.loadAnimation(searchresult.this,R.anim.shake);
        vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        
        
        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("size",size.getSelectedItem().toString());
                bundle.putString("crust",crust.getSelectedItem().toString());

                Intent intent = new Intent(searchresult.this,pavithra function );
                intent.putExtra("size", size.getSelectedItem().toString());
                intent.putExtra("crust",crust.getSelectedItem().toString());

                if(size.getSelectedItem().toString().equals("        ")){
                    Toast.makeText(searchresult.this,"Select size!",Toast.LENGTH_SHORT).show();
                    size.startAnimation(animShake);
                    vib.vibrate(120);
                }else if (crust.getSelectedItem().toString().equals("        ")){
                    Toast.makeText(searchresult.this,"Select crust!",Toast.LENGTH_SHORT).show();
                    size.startAnimation(animShake);
                    vib.vibrate(120);
                }
            }
        });
        
    }
    
}
