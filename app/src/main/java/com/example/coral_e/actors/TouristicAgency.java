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
        myIsland.addIncome(this.getActorLevel()*myIsland.touristicValue());
        if (myIsland.getGlobalAwareness()<10)
        {
            Biodiversity affectedBio = myIsland.getIslandBio().get(new Random().nextInt(myIsland.getIslandBio().size()));
            affectedBio.lowerBioPopulation((int)(affectedBio.getBioPopulation()*0.1*this.getActorLevel()));
        }
        else {
            myIsland.increaseAwareness(2*getActorLevel());
        }
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO part en croisière dans une autre île de l'archipèle, générant de l'argent en fonction de l'ecosystème de l'île visitée.
    }

    @Override
    public void evolve() {
        //TODO possibilité d'évolution -> bio tourisme, tourisme de masse
    }
}
