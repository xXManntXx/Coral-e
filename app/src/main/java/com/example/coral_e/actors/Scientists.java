package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

public class Scientists extends Actor{
    public Scientists() {
        super("Laboratoire de recherche", "Lieu peuplé de scientifiques en blouse blanche, étudiant la biologie et les hommes.");
    }

    //public method

    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseAwareness(5*getActorLevel());
        myIsland.increaseSocialLvl(5*getActorLevel());
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO send a diver to inspect coral reefs giving the player precious advice
    }

    @Override
    public void evolve(Island myIsland) {
        //TODO Aquarium de conservation
    }

    @Override
    public void evolve() {
        this.setActorLevel(this.getActorBudget()/30);
    }
}
