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
    private boolean actorActivity; //when evolve, turn to false

    //Constructor
    public Actor(String myActorName, String myActorDescription) {
        this.actorName = myActorName;
        this.actorDescription = myActorDescription;
        this.actorLevel=1;
        this.actorBudget=1;
        this.actorActivity = true;
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
    protected void setActorName(String myActorName) {
        actorName = myActorName;
    }

    protected void setActorDescription(String myActorDescription) {
        actorDescription = myActorDescription;
    }

    public void setActorBudget(int myBudget) {
        this.actorBudget = myBudget;
    }

    public void setActorLevel(int myActorLevel) {
        actorLevel = myActorLevel;
    }


    //Modifier
    public void increaseLevel(int myValue)
    {
        this.actorLevel+=myValue;
    }

    protected void deactivateActor()
    {
        this.actorActivity=false;
    }

    public void increaseActorBudget(int myValue) {this.actorBudget+=myValue;}

    //public method
    public abstract void usePassive(Island myIsland); //Passive aptitude, used each begin of turn or on acquisition
    public abstract void useActive(Archipelago myArchipelago); //Active aptitude, used at actor activation
    public abstract void evolve(Island myIsland);//Modify the level based on the budget value
}
