package com.nathanhuisman.charactersheetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public String[] characterClasses = {"Barbarian", "Champion", "Fighter", "Ranger", "Rouge"};

    private EditText characterName;
    private Spinner chosenClass;

    ImageButton swordImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swordImageButton = findViewById(R.id.mainNextButton);

        chosenClass = findViewById(R.id.selectInitialClass);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item,characterClasses);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chosenClass.setAdapter(adapter);

        characterName = findViewById(R.id.characterNameEntry);
    }



    //when the sword next button is clicked, grab the chosen class and name and give it to the buildCharacter class
    public void onNextButtonClick(View view){

        int selectedClass = chosenClass.getSelectedItemPosition();

        String playerName = characterName.getText().toString();
        String playerClass = chosenClass.getItemAtPosition(selectedClass).toString();

        Intent intent = new Intent(this,buildCharacter.class);
        intent.putExtra("CHARACTER_NAME", new String[] {playerName, playerClass});
        startActivity(intent);
    }



}