package com.example.coral_e.actors;
import com.example.coral_e.Island;
import com.example.coral_e.Archipelago;

/*
---ACTOR---
Physical card type representing the user of the see or of the island.
Each actor card got a QR-code that can be scanned
*/

public abstract class Actor {
    private String actorName;
    private String actorDescription;
    private int actorBudget; //used to determine the evolution of the actor
    private int actorLevel;  //used to determine the efficiency of the actor
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

    public boolean isActorActiv() {
        return actorActivity;
    }

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

    public void increaseActorBudget(int myValue) {this.actorBudget+=myValue;this.evolve();}

    //public method
    public abstract void usePassive(Island myIsland); //Passive aptitude, used each begin of turn or on acquisition
    public abstract void useActive(Archipelago myArchipelago); //Active aptitude, used at actor activation by scan
    public abstract void evolve(Island myIsland);//Modify the level based on the budget value.
                                                // If conditions are fulfilled, turn this actor into a non basic actor by deactivating this one and adding a new evolved one into the island.

    //TODO to delete when data transfer will be better handled
    //more simple version where the actor only modify himself without evolving into another actor
    public abstract void evolve();
}
