package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

import java.util.Random;

public class TouristicAgency extends Actor {
    public TouristicAgency()
    {
        super("Agence touristique.","Ensemble des structures et du personnel gérant le tourisme.");
    }

    //public method

    @Override
    public void usePassive(Island myIsland){
        myIsland.increaseIncome(this.getActorLevel()*myIsland.touristicValue());
        if (myIsland.getGlobalAwareness()<10)
        {
            //randomly chose a specie to affect
            Biodiversity affectedBio = myIsland.getIslandBio().get(new Random().nextInt(myIsland.getIslandBio().size()));
            affectedBio.lowerBioPopulation((int)(affectedBio.getBioPopulation()*0.1*this.getActorLevel()));
        }
        else {
            myIsland.increaseAwareness(2*getActorLevel());
        }
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO cruise into another island, generating money for both island regarding of the biodiversity on this island. Can damage the biodiversity
    }

    @Override
    public void evolve(Island myIsland) {
        //TODO can evolve into bio-tourism or massive-tourism
    }

    @Override
    public void evolve() {
        this.setActorLevel(this.getActorBudget()/15);
    }

}
