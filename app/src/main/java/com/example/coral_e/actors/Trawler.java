package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

public class Trawler extends Fisherman{
    public Trawler(int baseLvl) {
        this.setActorName("Chalutier");
        this.setActorDescription("Un large bâteau de pêche qui ratisse les océans à l'aide d'un filet pour pêcher du poisson.");
        this.setActorLevel(baseLvl);
    }

    //public method
    @Override
    public void usePassive(Island myIsland) {
        for (Biodiversity tempBio : myIsland.getIslandBio()) {
            if (tempBio.getRealm().equals("Fauna") && tempBio.getFoodValue()>0){
                int caughtFish = Math.min((5 * this.getActorLevel()), (int) (tempBio.getBioPopulation() / 10));
                myIsland.increaseIncome(tempBio.getFoodValue()*caughtFish);
                tempBio.lowerBioPopulation(caughtFish);
            }
            if (tempBio.getRealm().equals("Coral"))
            {
                tempBio.multiplyBioPop(0.8);
            }
        }
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO pêche dans les courants, impactant l'ecosysteme de toutes les autres îles
    }
}
