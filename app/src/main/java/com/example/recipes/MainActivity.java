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
    String[] countries = { "Богиня вечности", "Смертная свобода", "Огненная птица", "Каменный контракт", "Вдалеке от святых"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countriesList = findViewById(R.id.countriesList);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.listactivity, R.id.textView4,countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedItem = countries[position];
                recipe = Arrays.asList(countries).indexOf(selectedItem);
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
