package com.example.coral_e;

import java.util.ArrayList;
import java.util.List;


//each player got an island which regroup everything they possessed
public final class Island {

    private int islandID = 0;
    private String islandName;
    private int socialLevel;
    private int globalAwareness;
    private int resources;
    private int income;
    private List<Law> islandLaws = new ArrayList<Law>();

    //Constructor
    public Island() {
        new Island("Mon île");
    }

    public Island(String myIslandName) {
        this.islandName = myIslandName;
        this.socialLevel = 0;
        this.globalAwareness = 0;
        this.resources = 0;
        this.income = 0;
        //TODO add all existing laws in islandLaws
    }

    //Getter
    public int getIslandID() {
        return islandID;
    }

    public String getIslandName() {
        return islandName;
    }

    public int getSocialLevel() {
        return socialLevel;
    }

    public int getGlobalAwareness() {
        return globalAwareness;
    }

    public int getResources() {
        return resources;
    }

    public int getIncome() {
        return income;
    }

         //Return voted Island Laws
    public ArrayList<Law> getVotedLaws() {
        ArrayList<Law> myVotedLaws = new ArrayList<Law>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVoted()) {
                myVotedLaws.add(tempLaw);
            }
        }
        return myVotedLaws;
    }

            //Return visible Island Laws
    public ArrayList<Law> getVisibleLaws() {
        ArrayList<Law> myVisibleLaws = new ArrayList<Law>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVisible()) {
                myVisibleLaws.add(tempLaw);
            }
        }
        return myVisibleLaws;
    }

    //Setter
    public void setIslandID(int myIslandID) {
        this.islandID = myIslandID;
    }

    public void setSocialLevel(int mySocialLevel) {
        this.socialLevel = mySocialLevel;
    }

    public void setGlobalAwareness(int myGlobalAwareness) {
        this.globalAwareness = myGlobalAwareness;
    }

    public void setResources(int myResources) {
        this.resources = myResources;
    }

    public void setIncome(int myIncome) {
        this.income = myIncome;
    }

    //Public Methods

    public void generateIncome() {
        this.resources += this.income;
    }

    public boolean isVoted(String searchedLawName) {
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.getLawName() == searchedLawName) {
                return tempLaw.isVoted();
            }
        }
        return false;
    }
}