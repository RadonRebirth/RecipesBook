package com.example.recipes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int recipe;
    String selectedItem;
    String[] countries = { "Борщ", "Пельмени", "Вишнёвый десерт", "Помидоры Чили", "Салат Цезарь"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView selection = findViewById(R.id.selection);
        ListView countriesList = findViewById(R.id.countriesList);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                //TextView text = findViewById(R.id.textView);
                selectedItem = countries[position];
                recipe = Arrays.asList(countries).indexOf(selectedItem);
                selection.setText(selectedItem);
                Intent intent = new Intent(MainActivity.this, Recipe.class);
                intent.putExtra("selectedItem",recipe);
                startActivity(intent);
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedItem", recipe);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("selectedItem")) {
            recipe = savedInstanceState.getInt("selectedItem");
        }
    }
}