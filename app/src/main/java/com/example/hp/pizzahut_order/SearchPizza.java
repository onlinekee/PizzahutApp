package com.example.hp.pizzahut_order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    String[] varieties = {"All", "CLASSIC", "SIGNATURE", "SUPREME"};
    String[] pizzanames = {"Cheese Lover", "Veggie Supreme", "Spicy Veggie Panner", "Devilled Chicken", "Chicken Bacon"};
    int[] pizzaimage = {R.drawable.cheeselover, R.drawable.veggiesupreme, R.drawable.spicyveggiepanner, R.drawable.devilledchicken, R.drawable.chickenbacon};
    ArrayAdapter<Pizza> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pizza);

        pizzavariety = (Spinner) findViewById(R.id.spinner_pizzatype);
        pizzavariety.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, varieties));

        gridView = (GridView) findViewById(R.id.gridview_pizza);
        gridView.setAdapter(new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, getPizzas()));

        pizzatype = (Spinner) findViewById(R.id.spinner_pizzaveg);


        //final Adapter adapter = new Adapter(this, this.getPizza());

        pizzavariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < varieties.length) {
                    getSelectedItemData(position);
                } else {
                    Toast.makeText(SearchPizza.this, "Selected Item Does Not Exist", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private ArrayList<Pizza> getPizzas(){
        ArrayList<Pizza> data = new ArrayList<>();
        data.clear();

        data.add(new Pizza(1, "CHEESE LOVERS"));
        data.add(new Pizza(1, "VEGGIE SUPREME"));
        data.add(new Pizza(2, "CHICKEN BACON"));
        data.add(new Pizza(2, "SPICY CHICKEN"));
        data.add(new Pizza(3, "'SPICY PANNER SUPREME"));

        return data;
    }

    private void getSelectedItemData(int varietyId) {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        if (varietyId == 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getPizzas());

        } else {
            for (Pizza p : getPizzas()) {
                if (p.getVarietyID() == varietyId) {
                    pizzas.add(p);
                }
            }

            adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, pizzas);
        }

        gridView.setAdapter(adapter);

    }

}
//    private ArrayList<PizzaBody> getSelectedPizza(){
//        ArrayList<PizzaBody> data = new ArrayList<>();
//        data.clear();
//
//        data.add(new PizzaBody("Spicy chicken", 1));
//        data.add(new PizzaBody(""))
//
//
//
//    }
//}
