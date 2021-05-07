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

    public int selectedRace;
    public int selectedHeritage;

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
        Spinner heritageSpinner = findViewById(R.id.heritageSpinner);
        TextView description = findViewById(R.id.raceDescriptionLabel);
        TextView heritageDescription = findViewById(R.id.heritageDescription);


        //set initial values for races
        ArrayAdapter<String> adapter = new ArrayAdapter<>(buildCharacter.this,
                android.R.layout.simple_spinner_item, races);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        racesSpinner.setAdapter(adapter);



        //matches up the race description to the race and also lets the heritage spinner know what heritages are available
        racesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedRace = racesSpinner.getSelectedItemPosition();
                description.setText(raceDescriptions[selectedRace]);

                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(buildCharacter.this,
                        android.R.layout.simple_spinner_item, heritages[selectedRace]);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                heritageSpinner.setAdapter(adapter2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }
        });

        heritageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHeritage = heritageSpinner.getSelectedItemPosition();
                heritageDescription.setText(heritagesDescriptions[selectedRace][selectedHeritage]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    public void onHeritageDescriptionClick(View view){
        TextView descriptionText = findViewById(R.id.heritageDescription);
        if(descriptionText.getMaxLines() == 1) {
            descriptionText.setMaxLines(10);
        } else {
            descriptionText.setMaxLines(1);
        }
    }

}