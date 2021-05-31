package com.example.coral_e;

import com.example.coral_e.biodiversity.Biodiversity;
import com.example.coral_e.events.Event;
import com.example.coral_e.laws.BeachPrivatization;
import com.example.coral_e.laws.FreeTrade;
import com.example.coral_e.laws.GreenExcursion;
import com.example.coral_e.laws.Law;
import com.example.coral_e.laws.RegulatedFishing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//created by the host of the game only, contains every other island and general game information
final public class Archipelago {
    private List<Island> federateIslands = new ArrayList<Island>(); //contain the island of each player
    private List<Law> archipelagoLaws = new ArrayList<Law>();
    private int nbPlayer;
    private int presentTurn;

    public Archipelago(Island hostIsland) {
        this.federateIslands.add(hostIsland);
        this.nbPlayer=1;
        this.presentTurn = 1;
        //TODO add all existing laws in archipelagoLaws
        this.archipelagoLaws.add(new RegulatedFishing());
        this.archipelagoLaws.add(new BeachPrivatization());
        this.archipelagoLaws.add(new FreeTrade());
        this.archipelagoLaws.add(new GreenExcursion());

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

    public int getPresentTurn() {
        return presentTurn;
    }

    //modifier
    public void addIsland(Island playerIsland){
        this.federateIslands.add(playerIsland);
        this.nbPlayer++;
    }

    //public method
    public void passTurn()
    {
        this.presentTurn+=1;
        for(Island tempIsland : this.getFederateIslands())
        {
            tempIsland.activateEvents(this.presentTurn);
            tempIsland.sufferEvent();
        }
    }

}

