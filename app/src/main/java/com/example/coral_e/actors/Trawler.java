package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

public class Trawler extends Fisherman{
    public Trawler(int baseLvl, int baseBudget) {
        this.setActorName("Chalutier");
        this.setActorDescription("Un large bâteau de pêche qui ratisse les océans à l'aide d'un filet pour pêcher du poisson.");
        this.setActorLevel(baseLvl);
        this.setActorBudget(baseBudget);
    }

    //public method
    @Override
    public void usePassive(Island myIsland) {
        //fish everything without distinction
        for (Biodiversity tempBio : myIsland.getIslandBio()) {
            if (tempBio.getRealm().equals("Fauna") && tempBio.getFoodValue()>0){
                int caughtFish = Math.min((5 * this.getActorLevel()), tempBio.getBioPopulation() / 10);
                myIsland.increaseIncome(tempBio.getFoodValue()*caughtFish);
                tempBio.lowerBioPopulation(caughtFish);
            }
            //damage corals
            if (tempBio.getRealm().equals("Coral"))
            {
                tempBio.multiplyBioPop(0.8);
            }
        }
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO fish into full of life current, impacting every player ecosystems
    }
}
