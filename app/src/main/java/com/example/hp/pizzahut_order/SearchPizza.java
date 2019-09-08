package com.example.hp.pizzahut_order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
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

    String[] types = {"All", "Veg", "Non Veg"};

    String[] pizzanames = {"Cheese Lover", "Veggie Supreme", "Spicy Veggie Panner", "Devilled Chicken", "Chicken Bacon"};

    int[] pizzaimage = {R.drawable.cheeselover, R.drawable.veggiesupreme, R.drawable.spicyveggiepanner, R.drawable.devilledchicken, R.drawable.chickenbacon};
    ArrayAdapter<Pizza> adapter;
    CustomGridViewActivity adapterGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pizza);

        pizzavariety = (Spinner) findViewById(R.id.spinner_pizzatype);
        pizzavariety.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, varieties));



        //CustomGridViewActivity adapterView = new CustomGridViewActivity(SearchPizza.this, pizzanames, pizzaimage);
        adapterGridView = new CustomGridViewActivity(this, getPizzas());
        gridView = (GridView) findViewById(R.id.gridview_pizza);

        //gridView.setAdapter(new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, getPizzas()));
        gridView.setAdapter(adapterGridView);
        pizzatype = (Spinner) findViewById(R.id.spinner_pizzaveg);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), pizzanames[position], Toast.LENGTH_SHORT).show();
            }
        });
        //final Adapter adapter = new Adapter(this, this.getPizza());

        pizzavariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < varieties.length) {
                    getSelectedItemData(position, pizzatype.getSelectedItemPosition());
                } else {
                    Toast.makeText(SearchPizza.this, "Selected Item Does Not Exist", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pizzatype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < types.length) {
                    getSelectedItemData(pizzavariety.getSelectedItemPosition(), position);
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

        data.add(new Pizza(1,1, pizzanames[0], pizzaimage[0]));
        data.add(new Pizza(1,1, pizzanames[1], pizzaimage[1]));
        data.add(new Pizza(1,2, pizzanames[2], pizzaimage[2]));
        data.add(new Pizza(2,2, pizzanames[3], pizzaimage[3]));
        data.add(new Pizza(2,3, pizzanames[4], pizzaimage[4]));

        return data;
    }

    private void getSelectedItemData(int varietyId, int typeID) {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        if ((varietyId == 0) && (typeID == 0)) {
            adapterGridView = new CustomGridViewActivity(this, getPizzas());

        }else if((varietyId == 0) && (typeID > 0)){
            for (Pizza p : getPizzas()) {
                if (p.getTypeID() == typeID) {
                    pizzas.add(p);
                }
            }
            adapterGridView = new CustomGridViewActivity(this, pizzas);
        }else if((varietyId > 0) && (typeID == 0)) {
            for (Pizza p : getPizzas()) {
                if (p.getVarietyID() == varietyId) {
                    pizzas.add(p);
                }
            }
            adapterGridView = new CustomGridViewActivity(this, pizzas);
        } else {
            for (Pizza p : getPizzas()) {
                if ((p.getVarietyID() == varietyId) && (p.getTypeID() == typeID)) {
                    pizzas.add(p);
                }
            }
            adapterGridView = new CustomGridViewActivity(this, pizzas);
            //adapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_list_item_1, pizzas);
        }

        gridView.setAdapter(adapterGridView);

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
