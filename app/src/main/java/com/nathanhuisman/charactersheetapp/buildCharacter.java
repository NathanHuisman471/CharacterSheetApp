package com.nathanhuisman.charactersheetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class buildCharacter extends AppCompatActivity {

    public String buildTitle;
    public String[] nameAndClass;

    public int flawExists = 1;
    String[] otherThings = {"","","","","","","",""};

//strings
    public String[] races = {"Dwarf", "Elf", "Gnome", "Halfling", "Human"};
    public String[][] heritages = {{"Ancient-Blooded Dwarf", "Anvil Dwarf", "Death Warden Dwarf", "Elemental Heart Dwarf"},
                                    {"Ancient Elf", "Woodland Elf"},
                                    {"Fey-Touched Gnome", "Vivacious Gnome", "Wellspring Gnome"},
                                    {"Hillock Halfling", "Nomadic Halfling" },
                                    {"Skilled Heritage", "Versatile Heritage", "WinterTouched Human"}};

    public String[] raceDescriptions ={"These short and stocky defenders of mountain fortresses are often seen as stern and humorless. Known for mining the earths treasures and crafting magnificent items from ore and gemstones, they have an unrivaled affinity for the bounties of the deep earth. Dwarves also have a tendency toward traditionalism and isolation that sometimes manifests as xenophobia.",
                                    "Tall, noble, and often haughty, elves are long-lived and subtle masters of the wilderness. Elves excel in the arcane arts. Often they use their intrinsic link to nature to forge new spells and create wondrous items that, like their creators, seem nearly impervious to the ravages of time. A private and often introverted race, elves can give the impression they are indifferent to the plights of others.",
                                    "Expatriates of the strange land of fey, these small folk have a reputation for flighty and eccentric behavior. Many gnomes are whimsical artisans and tinkers, creating strange devices powered by magic, alchemy, and their quirky imagination. Gnomes have an insatiable need for new experiences that often gets them in trouble.",
                                    "Members of this diminutive race find strength in family, community, and their own innate and seemingly inexhaustible luck. While their fierce curiosity is sometimes at odds with their intrinsic common sense, halflings are eternal optimists and cunning opportunists with an incredible knack for getting out the worst situations.",
                                    "Ambitious, sometimes heroic, and always confident, humans have an ability to work together toward common goals that makes them a force to be reckoned with. Though short-lived compared to other races, their boundless energy and drive allow them to accomplish much in their brief lifetimes."};

    //text descriptions of the races. are in the same order as the heritages
    public String[][] heritagesDescriptions = {{"Dwarven heroes of old could shrug off their enemies’ magic, and some of that resistance manifests in you. You gain the Call on Ancient Blood reaction.",
                                                "You are a descendant of a famed crafter and have your own amazing talent. Other dwarves might consider this a blessing from your ancestors or from the Forgefather himself, depending on where you grew up. You become trained in Crafting (or another skill if you were already trained in Crafting) and gain the Specialty Crafting skill feat, but you can pick two different specialties instead of one.",
                                                "Your ancestors have been tomb guardians for generations, and the power they cultivated to ward off necromancy has passed on to you. If you roll a success on a saving throw against a necromancy effect, you get a critical success instead.",
                                                "Whether through a connection to Torag’s forge, the azers of the Plane of Fire, or another source, you can exude a burst of energy. Mbe’ke and Taralu dwarves of the Mwangi Expanse believe this heritage is a gift from dragons or elemental spirits. Choose one of the following damage types: acid, cold, electricity, or fire. Once chosen, this can’t be changed. You gain the Energy Emanation activity."},

                                                {"In your long life, you’ve dabbled in many paths and many styles. Choose a class other than your own. You gain the multiclass dedication feat for that class, even though you don’t meet its level prerequisite. You must still meet its other prerequisites to gain the feat.",
                                                "You're adapted to life in the forest or the deep jungle, and you know how to climb trees and use foliage to your advantage. When Climbing trees, vines, and other foliage, you move at half your Speed on a success and at full Speed on a critical success (and you move at full Speed on a success if you have Quick Climb). This doesn't affect you if you're using a climb Speed."},

                                                {"The blood of the fey is so strong within you that you're truly one of them. You gain the fey trait, in addition to the gnome and humanoid traits. Choose one cantrip from the primal spell list. You can cast this spell as a primal innate spell at will. A cantrip is heightened to a spell level equal to half your level rounded up. You can change this cantrip to a different one from the same list once per day by meditating to realign yourself with the First World; this is a 10-minute activity that has the concentrate trait.",
                                                "You have an incredibly strong connection to the positive energy that flows through the First World, making it harder to attack your life force with negative energy. You gain negative resistance equal to half your level (minimum 1). When you have the doomed condition, the condition affects you as if its value was 1 lower than it actually is (doomed 1 has no effect, doomed 2 causes you to die at dying 3, and so on).",
                                                "Some other source of magic has a greater hold on you than the primal magic of your fey lineage does. This connection might come from an occult plane or an ancient occult song; a deity, celestial, or fiend; magical effluent left behind by a mage war; or ancient rune magic."},

                                                {"Accustomed to a calm life in the hills, your people find rest and relaxation especially replenishing, particularly when indulging in creature comforts. When you regain Hit Points overnight, add your level to the Hit Points regained. When anyone uses the Medicine skill to Treat your Wounds, you can eat a snack to add your level to the Hit Points you regain from their treatment. ",
                                                "Your ancestors have traveled from place to place for generations, never content to settle down. You gain two additional languages of your choice, chosen from among the common and uncommon languages available to you, and every time you take the Multilingual feat, you gain another new language. "},

                                                {"Your ingenuity allows you to train in a wide variety of skills. You become trained in one skill of your choice. At 5th level, you become an expert in the chosen skill.",
                                                "Humanitys versatility and ambition have fueled its ascendance to be the most common ancestry in most nations throughout the world. Select a general feat of your choice for which you meet the prerequisites (as with your ancestry feat, you can select this general feat at any point during character creation).",
                                                "The power of winter flows through you. This heritage is most common among the Jadwiga of Irrisen, due to their descent from Baba Yaga, and certain Erutaki touched by the spirits. You gain cold resistance equal to half your level (minimum 1), and you treat environmental cold effects as if they were one step less extreme (incredible cold becomes extreme, extreme cold becomes severe, and so on)."}};

    public String[] background = {"Acrobat" , "Bandit", "Barkeep", "Gladiator", "Prisoner"};

    public String[] backgroundDescriptions = {"In a circus or on the streets, you earned your pay by performing as an acrobat. You might have turned to adventuring when the money dried up, or simply decided to put your skills to better use.\n" + "\n" + "Choose two ability boosts. One must be to Strength or Dexterity, and one is a free ability boost.",
                                                "Your past includes no small amount of rural banditry, robbing travelers on the road and scraping by. Whether your robbery was sanctioned by a local noble or you did so of your own accord, you eventually got caught up in the adventuring life. Now, adventure is your stock and trade, and years of camping and skirmishing have only helped.\n" + "\n" + "Choose two ability boosts. One must be to Dexterity or Charisma, and one is a free ability boost.",
                                                "You have five specialties: hefting barrels, drinking, polishing steins, drinking, and drinking. You worked in a bar, where you learned how to hold your liquor and rowdily socialize.\n" + "\n" + "Choose two ability boosts. One must be to Constitution or Charisma, and one is a free ability boost.",
                                                "The bloody games of the arena taught you the art of combat. Before you attained true fame, you departed—or escaped—the arena to explore the world. Your skill at drawing both blood and a crowd’s attention pay off in a new adventuring life.\n" + "\n" + "Choose two ability boosts. One must be to Strength or Charisma, and one is a free ability boost.",
                                                "You might have been imprisoned for crimes (whether you were guilty or not), or enslaved for some part of your upbringing. In your adventuring life, you take full advantage of your newfound freedom.\n" + "\n" + "Choose two ability boosts. One must be to Strength or Constitution, and one is a free ability boost."};

    public String [][] boosts = {{"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"}, {"Strength"}, {"Dexterity"}, {"Constitution"}, {"Intelligence"}, {"Charisma"}, {"Wisdom"}};
    public String [][] backgroundBoosts = {{"Strength", "Dexterity"},{"Dexterity","Charisma"},{"Constitution","Charisma"},{"Strength","Charisma"},{"Strength","Constitution"}};

    public String [] weapons = {"Long Sword (1d8s)", "Short Bow (1d6p, range:60)"};

    public int selectedRace;
    public int selectedHeritage;
    public int selectedBackground;
    public int selectedWeapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_character);

        TextView error = findViewById(R.id.errorLabel);
        TextView title = findViewById(R.id.buildTitle);

        //grab the sent name and class
        nameAndClass = getIntent().getStringArrayExtra("CHARACTER_NAME");

        //build string containing the sent name and class and set it to the title
        buildTitle = nameAndClass[0] + " the " + nameAndClass[1];
        title.setText(buildTitle);
        otherThings[0] = nameAndClass[0];
        otherThings[1] = nameAndClass[1];

        //made error message invisible until an error occurs
        error.setVisibility(View.GONE);

        //create local instances of all the spinners
        Spinner racesSpinner = findViewById(R.id.raceSelector);
        Spinner heritageSpinner = findViewById(R.id.heritageSpinner);
        Spinner backSpinner = findViewById(R.id.backgroundSpinner);
        Spinner raceBoost1 = findViewById(R.id.raceBoost1);
        Spinner raceBoost2 = findViewById(R.id.raceBoost2);
        Spinner raceBoost3 = findViewById(R.id.raceBoost3);
        Spinner raceflaw1  = findViewById(R.id.raceFlaw1 );
        Spinner backBoost1 = findViewById(R.id.backBoost1);
        Spinner backBoost2 = findViewById(R.id.backBoost2);
        Spinner freeBoost1 = findViewById(R.id.freeBoost1);
        Spinner freeBoost2 = findViewById(R.id.freeBoost2);
        Spinner freeBoost3 = findViewById(R.id.freeBoost3);
        Spinner freeBoost4 = findViewById(R.id.freeBoost4);
        Spinner weaponsSpinner = findViewById(R.id.weaponSpinner);
        Spinner keyAbilitySpinner = findViewById(R.id.keyAbilitySpinner);
        //and all the textViews
        TextView description = findViewById(R.id.raceDescriptionLabel);
        TextView heritageDescription = findViewById(R.id.heritageDescription);
        TextView backDescription = findViewById(R.id.backgroundDescription);

        //set key attributes
        switch (nameAndClass[1]) {
            case "Barbarian": {//"Barbarian", "Champion", "Fighter", "Ranger", "Rouge"
                ArrayAdapter<String> adapter13 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[1]);
                adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                keyAbilitySpinner.setAdapter(adapter13);
                break;
            }
            case "Champion":
            case "Fighter":
            case "Ranger": {
                ArrayAdapter<String> adapter13 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, backgroundBoosts[0]);
                adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                keyAbilitySpinner.setAdapter(adapter13);
                break;
            }
            case "Rouge": {
                ArrayAdapter<String> adapter13 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[2]);
                adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                keyAbilitySpinner.setAdapter(adapter13);
                break;
            }
        }

        //set intitial values for all the drop downs
        //set initial values for races
        ArrayAdapter<String> adapter = new ArrayAdapter<>(buildCharacter.this,
                android.R.layout.simple_spinner_item, races);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        racesSpinner.setAdapter(adapter);

        //set initial values for the backgrounds
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(buildCharacter.this,
                android.R.layout.simple_spinner_item, background);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backSpinner.setAdapter(adapter3);

        ArrayAdapter<String> adapter8 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freeBoost1.setAdapter(adapter8);

        ArrayAdapter<String> adapter9 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freeBoost2.setAdapter(adapter9);

        ArrayAdapter<String> adapter10 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freeBoost3.setAdapter(adapter10);

        ArrayAdapter<String> adapter11 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        freeBoost4.setAdapter(adapter11);

        ArrayAdapter<String> adapter15 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, weapons);
        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weaponsSpinner.setAdapter(adapter15);



        //matches up the race description to the race and also lets the heritage spinner know what heritages are available
        racesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedRace = racesSpinner.getSelectedItemPosition();
                description.setText(raceDescriptions[selectedRace]);
                otherThings[2] = racesSpinner.getSelectedItem().toString();

                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, heritages[selectedRace]);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                heritageSpinner.setAdapter(adapter2);

                if(selectedRace == 0) {
                    flawExists = 0;
                    raceBoost3.setVisibility(View.VISIBLE);
                    raceflaw1.setVisibility(View.VISIBLE);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[3]);//"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost1.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[6]);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost2.setAdapter(adapter5);

                    ArrayAdapter<String> adapter51 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost3.setAdapter(adapter51);

                    ArrayAdapter<String> adapter52 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[5]);
                    adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceflaw1.setAdapter(adapter52);
                }
                else if(selectedRace == 1){
                    flawExists = 0;
                    raceBoost3.setVisibility(View.VISIBLE);
                    raceflaw1.setVisibility(View.VISIBLE);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[2]);//"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost1.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[4]);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost2.setAdapter(adapter5);

                    ArrayAdapter<String> adapter51 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost3.setAdapter(adapter51);

                    ArrayAdapter<String> adapter52 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[3]);
                    adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceflaw1.setAdapter(adapter52);
                }
                else if(selectedRace == 2){
                    flawExists = 0;
                    raceBoost3.setVisibility(View.VISIBLE);
                    raceflaw1.setVisibility(View.VISIBLE);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[3]);//"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost1.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[5]);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost2.setAdapter(adapter5);

                    ArrayAdapter<String> adapter51 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost3.setAdapter(adapter51);

                    ArrayAdapter<String> adapter52 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[1]);
                    adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceflaw1.setAdapter(adapter52);
                }
                else if(selectedRace == 3){
                    flawExists = 0;
                    raceBoost3.setVisibility(View.VISIBLE);
                    raceflaw1.setVisibility(View.VISIBLE);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[2]);//"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost1.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[6]);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost2.setAdapter(adapter5);

                    ArrayAdapter<String> adapter51 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost3.setAdapter(adapter51);

                    ArrayAdapter<String> adapter52 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[1]);
                    adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceflaw1.setAdapter(adapter52);

                }
                else if(selectedRace == 4){
                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);//"Strength", "Dexterity", "Constitution", "Intelligence", "Charisma", "Wisdom"
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost1.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost2.setAdapter(adapter5);

                    ArrayAdapter<String> adapter51 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter51.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceBoost3.setAdapter(adapter51);

                    ArrayAdapter<String> adapter52 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                    adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    raceflaw1.setAdapter(adapter52);

                    raceBoost3.setVisibility(View.GONE);
                    raceflaw1.setVisibility(View.GONE);
                    flawExists = 0;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }
        });

        heritageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHeritage = heritageSpinner.getSelectedItemPosition();
                heritageDescription.setText(heritagesDescriptions[selectedRace][selectedHeritage]);
                otherThings[3] = heritageSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        backSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBackground = backSpinner.getSelectedItemPosition();
                backDescription.setText(backgroundDescriptions[selectedBackground]);
                otherThings[4] = backSpinner.getSelectedItem().toString();

                ArrayAdapter<String> adapter6 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, backgroundBoosts[selectedBackground]);
                adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                backBoost1.setAdapter(adapter6);

                ArrayAdapter<String> adapter7 = new ArrayAdapter<>(buildCharacter.this, android.R.layout.simple_spinner_item, boosts[0]);
                adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                backBoost2.setAdapter(adapter7);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        weaponsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedWeapon = weaponsSpinner.getSelectedItemPosition();
                otherThings[5] = weaponsSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }


    public void onDescriptionClick(View view){
        TextView descriptionText = findViewById(R.id.raceDescriptionLabel);
        if(descriptionText.getMaxLines() == 1) {
            descriptionText.setMaxLines(15);
        } else {
            descriptionText.setMaxLines(1);
        }
    }

    public void onHeritageDescriptionClick(View view){
        TextView descriptionText = findViewById(R.id.heritageDescription);
        if(descriptionText.getMaxLines() == 1) {
            descriptionText.setMaxLines(15);
        } else {
            descriptionText.setMaxLines(1);
        }
    }

    public void onBackgroundDescriptionClick(View view){
        TextView descriptionText = findViewById(R.id.backgroundDescription);
        if(descriptionText.getMaxLines() == 1) {
            descriptionText.setMaxLines(15);
        } else {
            descriptionText.setMaxLines(1);
        }
    }

    public void onFinishCharacterClick(View view){

        int error = 0;

        //check if any error exist
        Spinner race1 = findViewById(R.id.raceBoost1);
        Spinner race2 = findViewById(R.id.raceBoost2);
        Spinner race3 = findViewById(R.id.raceBoost3);
        Spinner key = findViewById(R.id.keyAbilitySpinner);
        Spinner flaw = findViewById(R.id.raceFlaw1);

        if(race1.getSelectedItem().toString().equals(race2.getSelectedItem().toString()) ||
                race1.getSelectedItem().toString().equals(race3.getSelectedItem().toString()) ||
                race2.getSelectedItem().toString().equals(race3.getSelectedItem().toString()) ){
            error =1;
        }

        Spinner back1 = findViewById(R.id.backBoost1);
        Spinner back2 = findViewById(R.id.backBoost2);
        if(back1.getSelectedItem().toString().equals(back2.getSelectedItem().toString())){
            error = 1;
        }

        Spinner free1 = findViewById(R.id.freeBoost1);
        Spinner free2 = findViewById(R.id.freeBoost2);
        Spinner free3 = findViewById(R.id.freeBoost3);
        Spinner free4 = findViewById(R.id.freeBoost4);

        if(free1.getSelectedItem().toString().equals(free2.getSelectedItem().toString()) ||
                free1.getSelectedItem().toString().equals(free3.getSelectedItem().toString()) ||
                free1.getSelectedItem().toString().equals(free4.getSelectedItem().toString()) ||
                free2.getSelectedItem().toString().equals(free3.getSelectedItem().toString()) ||
                free2.getSelectedItem().toString().equals(free4.getSelectedItem().toString()) ||
                free3.getSelectedItem().toString().equals(free4.getSelectedItem().toString()) ){
            error =1;
        }

        if(error != 1){
            int[] howMany = new int[10];

            howMany[0] = race1.getSelectedItemPosition();
            howMany[1] = race2.getSelectedItemPosition();
            howMany[3] = key.getSelectedItemPosition();
            howMany[4] = back1.getSelectedItemPosition();
            howMany[5] = back2.getSelectedItemPosition();
            howMany[6] = free1.getSelectedItemPosition();
            howMany[7] = free2.getSelectedItemPosition();
            howMany[8] = free3.getSelectedItemPosition();
            howMany[9] = free4.getSelectedItemPosition();

            int[] each = new int[6];

            if(flawExists == 1){
                howMany[2] = race3.getSelectedItemPosition();
                each[flaw.getSelectedItemPosition()] -=1;
            } else {
                howMany[2] = -1;
            }

            for(int i = 0; i<=9; i++){
                if(howMany[i] == 0){
                    each[0]++;
                }
                else if(howMany[i] == 1){
                    each[1]++;
                }
                else if(howMany[i] == 2){
                    each[2]++;
                }
                else if(howMany[i] == 3){
                    each[3]++;
                }
                else if(howMany[i] == 4){
                    each[4]++;
                }
                else if(howMany[i] == 5){
                    each[5]++;
                }
            }

            Intent intent = new Intent(this,characterDone.class);
            intent.putExtra("CHARACTER_INFO", each);
            intent.putExtra("MORE_INFO", otherThings);
            startActivity(intent);

        }
        else {
            TextView errorLabel = findViewById(R.id.errorLabel);
            errorLabel.setVisibility(View.VISIBLE);
        }

    }

}