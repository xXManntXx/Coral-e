package com.example.coral_e;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coral_e.adapters.LawAdapter;
import com.example.coral_e.laws.BeachPrivatization;
import com.example.coral_e.laws.GreenExcursion;
import com.example.coral_e.laws.Law;
import com.example.coral_e.laws.RegulatedFishing;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Voting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Voting extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Voting() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Voting.
     */
    // TODO: Rename and change types and number of parameters
    public static Voting newInstance(String param1, String param2) {
        Voting fragment = new Voting();
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
        View rootView = inflater.inflate(R.layout.fragment_voting, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            //Nav
            NavController navController = Navigation.findNavController(view);

            //Fetch
            VotingArgs args = VotingArgs.fromBundle(getArguments());
            TextView OBJECT = view.findViewById(R.id.Tool_NomIle);

            Island myIsland = args.getVotingIsland();
            OBJECT.setText(myIsland.getIslandName());

            VotingDirections.ActionVotingToBoard actionVtoB = VotingDirections.actionVotingToBoard(myIsland);


            ImageView back = view.findViewById(R.id.retour);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(actionVtoB);
                }
            });


            //Showing list of laws
            //data
            //TODO récupérer les lois de l'île en question
            List<Law> myLaws = new ArrayList<>();
            myLaws.add(new BeachPrivatization());
            myLaws.add(new GreenExcursion());
            myLaws.add(new RegulatedFishing());
            //TODO supprimer au dessus pour remplacer par les lois de lîle
            //get lists view
            ListView lawsListView = view.findViewById(R.id.myLaws_list_view);
            lawsListView.setAdapter(new LawAdapter(getContext(), myLaws));
        }
    }
}