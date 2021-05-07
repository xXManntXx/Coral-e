package com.example.coral_e;

import java.util.ArrayList;
import java.util.List;

public final class Island {
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
    }

    //Getter
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