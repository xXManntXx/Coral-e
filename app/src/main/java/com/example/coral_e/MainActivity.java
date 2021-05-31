package com.example.coral_e;

import androidx.annotation.Nullable;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    //Logs
    private static final String TAG = "MainActivity";

    /*TODO move all below to more accurate place
    // Initialisation
    Island playerIsland = new Island("Ma première île", "TestingBiome");
    //TODO If player is Host :
        Archipelago globalArchi = new Archipelago(playerIsland);
     */


    //First tests
    //TODO Delete all things below to put the real deal instead
    private TextView mGreetingText;
    private EditText mIslandName;
    private Button mPlayButton;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}