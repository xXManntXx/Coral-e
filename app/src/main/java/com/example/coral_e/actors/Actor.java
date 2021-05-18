package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

import java.util.ArrayList;

public abstract class Actor {
    private String actorName;
    private String actorDescription;
    private int budget; //used to determine the efficiency and the evolution of the actor
    private ArrayList<Actor> actorDevelopment;

    //Constructor
    public Actor(String myActorName, String myActorDescription) {
        this.actorName = myActorName;
        this.actorDescription = myActorDescription;
    }

    //getter
    public String getActorName() { return actorName; }

    public String getActorDescription() { return actorDescription; }

    public int getBudget() { return budget; }

    public ArrayList<Actor> getActorDevelopment() { return actorDevelopment; }

    //setter

    public void setBudget(int myBudget) {
        this.budget = myBudget;
    }

    //public method
    abstract void usePassive(Island myIsland); //Passive aptitude, used each end of turn
    abstract void useActive(Archipelago myArchipelago); //Active aptitude, used at actor activation
}
