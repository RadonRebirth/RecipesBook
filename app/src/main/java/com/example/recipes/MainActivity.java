package com.example.recipes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    int recipe;
    String selectedItem;
    ArrayList<String> lines = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countriesList = findViewById(R.id.countriesList);
        try {
            InputStream inputreader = getAssets().open("nameText.txt");
            Scanner scanner = new Scanner(inputreader);

            while(scanner.hasNextLine())
            {
                lines.add(scanner.nextLine());
            }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.listactivity, R.id.textView4,lines);
        countriesList.setAdapter(adapter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedItem = (String) lines.get(position);
                recipe = lines.indexOf(selectedItem);
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