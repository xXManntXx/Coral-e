package com.example.coral_e;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

public class Start extends Fragment {

    private static final String TAG = "start";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Button StartButton;
    private EditText IslandName;

    public Start() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EditText e1;
        View view =  inflater.inflate(R.layout.fragment_start, container, false);
        IslandName = (EditText) view.findViewById(R.id.IslandName);
        StartButton = (Button) view.findViewById(R.id.StartButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        StartButton.setEnabled(false);
        IslandName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                StartButton.setEnabled(s.toString().length()!=0);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        final NavController navController = Navigation.findNavController(view);

        StartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                String message = IslandName.getText().toString();
                Island myIsland = new Island(message,"TestingBiome");
                StartDirections.ActionStartToBoard action = StartDirections.actionStartToBoard(myIsland);
                Log.d(TAG,"TESTESTEST" + message);
                navController.navigate(action);
            }
        });



    }

}


