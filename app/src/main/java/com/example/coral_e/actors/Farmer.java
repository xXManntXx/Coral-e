package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

public class Farmer extends  Actor {
    public Farmer() {
        super("Cultivateur", "L'ensemble des personnes pratiquant l'élevage animal ou la culture végétale.");
    }

    //public method

    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseSocialLvl(5*getActorLevel());
        myIsland.increaseIncome(3*getActorLevel());
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO sell part of the production to other island, increasing their social and making profit
    }

    @Override
    public void evolve(Island myIsland) {
        //TODO involve into green agriculture or intensive agriculture
    }

    @Override
    public void evolve() {
        this.setActorLevel(this.getActorBudget()/10);
    }
}
