package com.nathanhuisman.charactersheetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public String[] characterClasses = {"Barbarian", "Champion", "Fighter", "Ranger", "Rouge"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.selectInitialClass);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item,characterClasses);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



}