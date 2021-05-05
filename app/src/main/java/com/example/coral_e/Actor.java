package com.example.coral_e;

import java.util.ArrayList;

abstract class Actor {
    private String actorName;
    private String actorDescription;
    private int budget; //used to determine the efficiency and the evolution of the actor
    private ArrayList<Actor> actorDevelopment;

    //Constructor
    public Actor(String myActorName, String myActorDescription, int myBudget) {
        this.actorName = myActorName;
        this.actorDescription = myActorDescription;
        this.budget = myBudget;
    }

    //getter
    public String getActorName() { return actorName; }

    public String getActorDescription() { return actorDescription; }

    public int getBudget() { return budget; }

    public ArrayList<Actor> getActorDevelopment() { return actorDevelopment; }
}
