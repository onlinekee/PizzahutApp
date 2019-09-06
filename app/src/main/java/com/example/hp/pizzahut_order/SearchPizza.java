package com.example.hp.pizzahut_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchPizza extends AppCompatActivity {
    Button btnsearch;
    GridView gridView;
    Spinner pizzatype, pizzavariety;
    String[] categories = {"All","CLASSIC","SIGNATURE","SUPREME"};
    String[] pizzanames = {"Cheese Lover","Veggie Supreme","Spicy Veggie Panner","Devilled Chicken","Chicken Bacon"};
    int[] pizzaimage = {R.drawable.cheeselover,R.drawable.veggiesupreme,R.drawable.spicyveggiepanner,R.drawable.devilledchicken,R.drawable.chickenbacon};
    ArrayAdapter<Pizza> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pizza);

        pizzavariety = (Spinner)findViewById(R.id.spinner_pizzaveg);
        pizzavariety.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, categories));

        gridView = (GridView)findViewById(R.id.gridview_pizza);
        gridView.setAdapter(new ArrayAdapter<Pizza>(this,android.R.layout.simple_list_item_1,getPizza()));

        pizzatype= (Spinner)findViewById(R.id.spinner_pizzatype);

        btnsearch = (Button)findViewById(R.id.button_searchpizza);

        final Adapter adapter = new Adapter(this,this.getPizza());

        pizzavariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String variety = "ALL";
                if (position == 1){
                    variety = "CLASSIC";

                }else if (position == 2){
                    variety = "SIGNATURE";
                }else if (position == 3){
                    variety = "SUPREME";
                }

                if(position >=0 && position <categories.length){
                    getSelectedItemData(variety);

                }else{
                    Toast.makeText(SearchPizza.this,"Selected Item Does Not Exist",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private ArrayList<Pizza> getPizza(){
        ArrayList<Pizza> data = new ArrayList<>();
        data.clear();

        data.add(new Pizza("CLASSIC", "VEG","Cheese Lovers",1));
        data.add(new Pizza("CLASSIC", "VEG","Veggie Supreme",2));
        data.add(new Pizza("SUPREME", "VEG","Spicy Veggie Panner",3));
        data.add(new Pizza("SUPREME", "NONVEG","Devilled Chicken",4));
        data.add(new Pizza("SIGNATURE", "NONVEG","Chicken Bacon",5));
//
//        for (int i = 0;i<pizzanames.length;i++){
//            pizza= new Pizza(null,null,pizzanames[i],pizzaimage[i]);
//            pizzas.add(pizza);
//        }
        return data;
    }

    private void getSelectedItemData(String variety){
        ArrayList<Pizza> pizzas = new ArrayList<>();
        if (variety == null ){
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getPizza());

        }else{
            for (Pizza pizza : getPizza()){
                if (pizza.getVariety().equals(variety)){
                    pizzas.add(pizza);
                }
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,pizzas);
        }

    }

}
