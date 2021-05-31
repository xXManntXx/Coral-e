package com.example.coral_e.events;

import com.example.coral_e.Island;
import com.example.coral_e.actors.Actor;
import com.example.coral_e.actors.Fisherman;
import com.example.coral_e.actors.TouristicAgency;
import com.example.coral_e.biodiversity.Biodiversity;

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
    public void happen(Island myIsland) {
        Actor crippledActor = myIsland.getActor(new TouristicAgency());
        if(!crippledActor.getActorName().equals("GoneWrong")) {
            if (crippledActor.getActorLevel()>1) {
                crippledActor.increaseLevel(-1);
            }
        }
        for(Biodiversity tempBio : myIsland.getIslandBio()) {
            if (tempBio.getTouristicValue() > 9) {
                tempBio.multiplyBioPop(1.5);
            }
        }
    }

    @Override
    public void activate(Island myIsland,int currentTurn) {
        this.setActive(this.getEventTurn().contains(currentTurn));
    }
}
