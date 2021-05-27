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
        myIsland.increaseSocialLvl(15);
        myIsland.increaseIncome(10);
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO vend ses productions dans les autres îles, gagnant de l'argent augmentant le social dans les autres villes
    }

    @Override
    public void evolve() {
        //TODO agriculture green ou agriculture intensive
    }
}
