package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Recipe extends AppCompatActivity {
    int recipe;
    String[] recipes = {"Борщ - надо приготовить", "Пельмени - залить кипятком", "Вишнёвый десерт - приготовить десерт", "Помидоры Чили - нарезать помидоры чили", "Салат Цезарь - нарезать салат цезарь"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        recipe = intent.getIntExtra("selectedItem",recipe);
        setContentView(R.layout.recipe);
        TextView text = findViewById(R.id.textView);
        text.setText(recipes[recipe]);
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.textView);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            recipe = savedInstanceState.getInt("selectedItem");
        }
    }
}