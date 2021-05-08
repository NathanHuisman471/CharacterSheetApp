package com.nathanhuisman.charactersheetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class characterDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_done);

        TextView title = findViewById(R.id.finalTitle);
        TextView race = findViewById(R.id.raceView);
        TextView heritage = findViewById(R.id.heritageView);
        TextView back = findViewById(R.id.backView);

        TextView strength = findViewById(R.id.strengthLabel);
        TextView dexterity = findViewById(R.id.dexterityLabel);
        TextView constitution = findViewById(R.id.constitutionLabel);
        TextView intelligence = findViewById(R.id.intellegenceLabel);
        TextView charisma = findViewById(R.id.charismaLabel);
        TextView wisdom = findViewById(R.id.wisdomLabel);

        TextView weaponLabel = findViewById(R.id.weaponLabel2);
        ImageView image = findViewById(R.id.weaponPic);

        String[] everything;
        everything = getIntent().getStringArrayExtra("MORE_INFO");

        int[] attr;
        attr = getIntent().getIntArrayExtra("CHARACTER_INFO");

        //label assigning
        String buildString = everything[0] + " the " + everything[1];
        title.setText(buildString);

        String buildString2 = "Race: " + everything[2];
        race.setText(buildString2);

        String buildString3 = "Heritage: " + everything[3];
        heritage.setText(buildString3);

        String buildString4 = "Background: " + everything[4];
        back.setText(buildString4);

        String buildString5 = "Weapon: " + everything[5];
        weaponLabel.setText(buildString5);

        //attribute assigning
        String attrString0 = "Strength:    " + (attr[0]*2+10);
        strength.setText(attrString0);

        String attrString1 = "Dexterity:   " + (attr[1]*2+10);
        dexterity.setText(attrString1);

        String attrString2 = "Constitution:" + (attr[2]*2+10);
        constitution.setText(attrString2);

        String attrString3 = "Intelligence:" + (attr[3]*2+10);
        intelligence.setText(attrString3);

        String attrString4 = "Charisma:    " + (attr[4]*2+10);
        charisma.setText(attrString4);

        String attrString5 = "Wisdom:      " + (attr[5]*2+10);
        wisdom.setText(attrString5);

        if(everything[5].equals("Long Sword (1d8s)")){
            image.setImageResource(R.drawable.sword2);
        } else {
            image.setImageResource(R.drawable.bow4);
        }


    }
}