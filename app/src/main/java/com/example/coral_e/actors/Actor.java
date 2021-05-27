package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

import java.util.ArrayList;

public abstract class Actor {
    private String actorName;
    private String actorDescription;
    private int actorBudget; //used to determine the evolution of the actor
    private int actorLevel;  //used to determine the efficiency of the actor
    private ArrayList<Actor> actorDevelopment;

    //Constructor
    public Actor(String myActorName, String myActorDescription) {
        this.actorName = myActorName;
        this.actorDescription = myActorDescription;
    }

    //getter
    public String getActorName() { return actorName; }

    public String getActorDescription() { return actorDescription; }

    public int getActorBudget() { return actorBudget; }

    public int getActorLevel() {
        return actorLevel;
    }

    public ArrayList<Actor> getActorDevelopment() { return actorDevelopment; }

    //setter

    public void setActorBudget(int myBudget) {
        this.actorBudget = myBudget;
    }

    public void setActorLevel(int myActorLevel) {
        actorLevel = myActorLevel;
    }

    //public method
    public abstract void usePassive(Island myIsland); //Passive aptitude, used each begin of turn or on acquisition
    public abstract void useActive(Archipelago myArchipelago); //Active aptitude, used at actor activation
    public abstract void evolve();//Modify the level based on the budget value
}
