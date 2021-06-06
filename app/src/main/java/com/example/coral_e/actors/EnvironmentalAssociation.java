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
        myIsland.increaseAwareness(5*this.getActorLevel());
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO visit an other island to augment their globalAwareness and restore their ecosystem
    }

    @Override
    public void evolve(Island myIsland) {
        this.setActorLevel(this.getActorBudget()/10);
        if (this.getActorLevel()>5) {
            myIsland.addActor(new ONG(this.getActorLevel(),this.getActorBudget()));
            this.deactivateActor();//will not be considered anymore
        }
    }

    @Override
    public void evolve() {
        this.setActorLevel(this.getActorBudget()/10);
    }
}
