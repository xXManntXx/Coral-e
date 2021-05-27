package com.example.coral_e.actors;

import android.util.Log;

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
            if (tempBio.getRealm()=="Fauna" && tempBio.getFoodValue()>0){
                int caughtFish = Math.min((5 * this.getActorLevel()), (int) (tempBio.getBioPopulation() / 10));
                Log.d(TAG,"Bio pêchable : " + tempBio.getBioName() + "caught : " + caughtFish);
                myIsland.addIncome(tempBio.getFoodValue()*caughtFish);
                Log.d(TAG,"Income increased by : " + tempBio.getFoodValue()*caughtFish + " (food value : " + tempBio.getFoodValue() + " )");
                tempBio.lowerBioPopulation(caughtFish);
            }
        }
    }
    @Override
    public void useActive(Archipelago myArchipelago) //generate income based on fishery
    {
        //TODO propose the player to select an island, and fish there
    }

    @Override
    public void evolve() {
        this.setActorLevel(this.getActorBudget()%25);
        //TODO suivant le niveau et l'île, transformation en acteur plus gros
    }
}
