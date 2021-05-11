package com.example.coral_e;

import java.util.ArrayList;
import java.util.List;

//created by the host of the game only, contains every other island and general game information
final public class Archipelago {
    private List<Island> federateIslands = new ArrayList<Island>(); //contain the island of each player
    private List<Law> archipelagoLaws = new ArrayList<Law>();
    private int nbPlayer;

    public Archipelago(Island hostIsland) {
        this.federateIslands.add(hostIsland);
        this.nbPlayer=1;
        //TODO add all existing laws in archipelagoLaws
    }

    //getter
    public int getNbPlayer() {
        return nbPlayer;
    }

    public List<Island> getFederateIslands() {
        return federateIslands;
    }

    public List<Law> getArchipelagoLaws() {
        return archipelagoLaws;
    }

            //Return visible IslandLaws
    public ArrayList<Law> getVisibleLaws() {
        ArrayList<Law> myVisibleLaws = new ArrayList<Law>();
        for (Law tempLaw : this.archipelagoLaws) {
            if (tempLaw.isVisible()) {
                myVisibleLaws.add(tempLaw);
            }
        }
        return myVisibleLaws;
    }

    //public methods
    public void addIsland(Island playerIsland){
        this.federateIslands.add(playerIsland);
        this.nbPlayer++;
    }

}

