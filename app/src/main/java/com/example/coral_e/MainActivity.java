package com.example.coral_e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coral_e.actors.Actor;
import com.example.coral_e.actors.Fisherman;

public class MainActivity extends AppCompatActivity {
    //Logs
    private static final String TAG = "MainActivity";


    // Initialisation
    Island playerIsland = new Island("Ma première île", "TestingBiome");
    //TODO If player is Host :
        Archipelago globalArchi = new Archipelago(playerIsland);

    //First tests
    //TODO Delete all things below to put the real deal instead
    private TextView mGreetingText;
    private EditText mIslandName;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.a_main_greeting_text);
        mIslandName = (EditText) findViewById(R.id.a_main_island_name_input);
        mPlayButton = (Button) findViewById(R.id.a_main_play_btn);

        mPlayButton.setEnabled(false);
        mIslandName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length()!=0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actor monPecheur = playerIsland.getIslandActors().get(0);
                Log.d(TAG,"Acteur choisit : " + monPecheur.getActorName());
                monPecheur.usePassive(playerIsland);
                mGreetingText.setText("New Income : " + playerIsland.getIncome() + "\nNew fish population : " + playerIsland.getIslandBio().get(0).getBioPopulation());
            }
        });
        mGreetingText.setText("Inital Income : " + playerIsland.getIncome() + "\nInitial fish population : " + playerIsland.getIslandBio().get(0).getBioPopulation());
    }

}