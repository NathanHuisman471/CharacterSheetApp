package com.nathanhuisman.charactersheetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class buildCharacter extends AppCompatActivity {

    public String buildTitle;
    public String[] nameAndClass;

    public String[] races = {"Dwarf", "Elf", "Gnome", "Halfling", "Human"};
    public String[] humanHeritages = {"Skilled Heritage", "Versatile Heritage", "WinterTouched Human"};

    public String[] raceDescriptions ={"These short and stocky defenders of mountain fortresses are often seen as stern and humorless. Known for mining the earths treasures and crafting magnificent items from ore and gemstones, they have an unrivaled affinity for the bounties of the deep earth. Dwarves also have a tendency toward traditionalism and isolation that sometimes manifests as xenophobia.",
                                    "Tall, noble, and often haughty, elves are long-lived and subtle masters of the wilderness. Elves excel in the arcane arts. Often they use their intrinsic link to nature to forge new spells and create wondrous items that, like their creators, seem nearly impervious to the ravages of time. A private and often introverted race, elves can give the impression they are indifferent to the plights of others.",
                                    "Expatriates of the strange land of fey, these small folk have a reputation for flighty and eccentric behavior. Many gnomes are whimsical artisans and tinkers, creating strange devices powered by magic, alchemy, and their quirky imagination. Gnomes have an insatiable need for new experiences that often gets them in trouble.",
                                    "Members of this diminutive race find strength in family, community, and their own innate and seemingly inexhaustible luck. While their fierce curiosity is sometimes at odds with their intrinsic common sense, halflings are eternal optimists and cunning opportunists with an incredible knack for getting out the worst situations.",
                                    "Ambitious, sometimes heroic, and always confident, humans have an ability to work together toward common goals that makes them a force to be reckoned with. Though short-lived compared to other races, their boundless energy and drive allow them to accomplish much in their brief lifetimes."};

    public int selectedRace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_character);

        TextView title = findViewById(R.id.buildTitle);

        //grab the sent name and class
        nameAndClass = getIntent().getStringArrayExtra("CHARACTER_NAME");

        //build string containing the sent name and class and set it to the title
        buildTitle = nameAndClass[0] + " the " + nameAndClass[1];
        title.setText(buildTitle);

        Spinner racesSpinner = findViewById(R.id.raceSelector);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(buildCharacter.this,
                android.R.layout.simple_spinner_item, races);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        racesSpinner.setAdapter(adapter);

        TextView description = findViewById(R.id.raceDescriptionLabel);


        racesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedRace = racesSpinner.getSelectedItemPosition();
                description.setText(raceDescriptions[selectedRace]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }


    public void onDescriptionClick(View view){
        TextView descriptionText = findViewById(R.id.raceDescriptionLabel);
        if(descriptionText.getMaxLines() == 1) {
            descriptionText.setMaxLines(10);
        } else {
            descriptionText.setMaxLines(1);
        }
    }


}