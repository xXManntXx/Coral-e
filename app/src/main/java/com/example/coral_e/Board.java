package com.example.coral_e;

import android.content.Intent;
import android.nfc.Tag;
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
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Board#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Board extends Fragment {

    private static final String TAG = "start";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String Tag;

    public Board() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Board.
     */
    // TODO: Rename and change types and number of parameters
    public static Board newInstance(String param1, String param2) {
        Board fragment = new Board();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if(getArguments() != null) {
            //enable navController
            NavController navController = Navigation.findNavController(view);

            //myIsland
            Island myIsland;

            //fetch Island from ...
            BoardArgs args = BoardArgs.fromBundle(getArguments());
            TextView OBJECT = view.findViewById(R.id.Tool_NomIle);
            TextView Step = view.findViewById(R.id.Tool_Etape);

            //...Start/Emplyement/Voting/Calling
            myIsland= args.getCurrentIsland();
            OBJECT.setText(" " + myIsland.getIslandName());
            Step.setText(" Tour : " + myIsland.getPresentTurn());
            Log.d(TAG,"TESTESTEST" + myIsland.getIslandName());



            //send to ....
            BoardDirections.ActionBoardToEmployement actionBtoE = BoardDirections.actionBoardToEmployement(myIsland);
            BoardDirections.ActionBoardToVoting actionBtoV = BoardDirections.actionBoardToVoting(myIsland);
            BoardDirections.ActionBoardToQrCode actionBtoQ = BoardDirections.actionBoardToQrCode(myIsland);
            BoardDirections.ActionBoardToEndTurn actionBtoEnd = BoardDirections.actionBoardToEndTurn(myIsland);


            TextView vote = view.findViewById(R.id.tampon);
            TextView appel = view.findViewById(R.id.icon_telephone);
            TextView acteur = view.findViewById(R.id.icon_acteur);
            Button end = view.findViewById(R.id.EndTurn);

            vote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(actionBtoV);
                }
            });
            appel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    navController.navigate(actionBtoQ);
                }
            });
            acteur.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(actionBtoE);
                }
            });
            end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(actionBtoEnd);
                }
            });
        }

    }
}