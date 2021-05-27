package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

public class EnvironmentalAssociation extends Actor {
    public EnvironmentalAssociation() {
        super("Association environnementale", "Association ayant pour vocation de protéger l'environnement.");
    }

    //public method

    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseAwareness(20);
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO intervient dans d'autres îles pour augmenter leur niveau d'awareness
    }

    @Override
    public void evolve() {
        //TODO en ONG
    }
}
