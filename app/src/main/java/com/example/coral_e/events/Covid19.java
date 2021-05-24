package com.example.coral_e.events;

import com.example.coral_e.Island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Covid19 extends Event {
    public Covid19(){
        super("Covid-19","Une pandémie mondiale se déclare. Les frontières ainsi que tous les commerces non essentiels se retrouvent fermés.");
        List<Integer> eventTurns = Arrays.asList(1);
        setEventTurn(eventTurns);
    }

    //public method

    @Override
    void happen(Island myIsland) {
        //TODO détruit le tourisme et le moral mais bénéficie l'écosystème
    }


}
