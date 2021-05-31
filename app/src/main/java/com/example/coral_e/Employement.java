package com.example.coral_e;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coral_e.actors.Actor;
import com.example.coral_e.actors.EnvironmentalAssociation;
import com.example.coral_e.actors.Fisherman;
import com.example.coral_e.actors.TouristicAgency;
import com.example.coral_e.adapters.ActorAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Employement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Employement extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Employement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Employement.
     */
    // TODO: Rename and change types and number of parameters
    public static Employement newInstance(String param1, String param2) {
        Employement fragment = new Employement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        ImageView back = view.findViewById(R.id.retour);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_employement_to_board);
            }
        });

        //Showing list of laws
        //data
        //TODO récupérer les acteurs de l'île en question
        List<Actor> myActors = new ArrayList<>();
        myActors.add(new Fisherman());
        myActors.add(new TouristicAgency());
        myActors.add(new EnvironmentalAssociation());
        //TODO supprimer au dessus pour remplacer par les acteurs de lîle
        //get lists view
        ListView actorsListView = view.findViewById(R.id.myActors_list_view);
        actorsListView.setAdapter(new ActorAdapter(getContext(),myActors));
    }
}