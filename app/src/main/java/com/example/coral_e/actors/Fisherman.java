package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

public class Fisherman extends Actor {
    //Logs
    private static final String TAG = "Fisherman";

    public Fisherman()
    {
        super("Fisherman","Représente la pêche à la ligne par les locaux.");
    }

    //public method
    @Override
    public void usePassive(Island myIsland) //generate income based on fishery
    {
        for (Biodiversity tempBio : myIsland.getIslandBio()) {
            if (tempBio.getRealm().equals("Fauna") && tempBio.getFoodValue()>0){
                if(!(myIsland.isLawVoted("REG_FISHING") && tempBio.getBioID().equals("BLACK_SHARK")))
                {
                    int caughtFish = Math.min((5 * this.getActorLevel()), (int) (tempBio.getBioPopulation() / 10));
                    myIsland.increaseIncome(tempBio.getFoodValue()*caughtFish);
                    tempBio.lowerBioPopulation(caughtFish);
                }
            }
        }
    }
    @Override
    public void useActive(Archipelago myArchipelago) //generate income based on fishery
    {
        //TODO propose the player to select an island, and fish there
    }

    @Override
    public void evolve(Island myIsland) {
        this.setActorLevel((int)this.getActorBudget()/25);
        if (this.getActorLevel()>3 && myIsland.getIslandFocus()<0)
        {
            myIsland.addActor(new Trawler(this.getActorLevel()));
            this.deactivateActor();
        }
    }
}
