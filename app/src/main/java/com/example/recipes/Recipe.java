package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Recipe extends AppCompatActivity {
    int recipe;
    ArrayList<String> countries = new ArrayList<String>();
    ArrayList<String> Texts= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        recipe = intent.getIntExtra("selectedItem",recipe);
        setContentView(R.layout.recipe);
        TextView text = findViewById(R.id.textView);
        TextView namedtext = findViewById(R.id.namedText);
        try {
            InputStream inputreader = getAssets().open("nameText.txt");
            InputStream inputreaderTexts = getAssets().open("Text.txt");
            Scanner scanner = new Scanner(inputreader);
            Scanner scanner2 = new Scanner(inputreaderTexts);

            while(scanner.hasNextLine())
            {
                countries.add(scanner.nextLine());
                Texts.add(scanner2.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String selectedItem = (String) countries.get(recipe);
        String selectedTexts = (String) Texts.get(recipe);
        namedtext.setText(selectedItem);
        text.setText(selectedTexts);
        ConstraintLayout fon = findViewById(R.id.Recipe);
        switch (recipe){
            case 0:
                fon.setBackground(getResources().getDrawable(R.drawable.first));
                break;
            case 1:
                fon.setBackground(getResources().getDrawable(R.drawable.second));
                break;
            case 2:
                fon.setBackground(getResources().getDrawable(R.drawable.third));
                break;
            case 3:
                fon.setBackground(getResources().getDrawable(R.drawable.fourth));
                break;
            case 4:
                fon.setBackground(getResources().getDrawable(R.drawable.fifth));
                break;
        }
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