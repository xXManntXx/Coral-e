package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

public class ONG extends EnvironmentalAssociation{
    public ONG(int baseLvl, int baseBudget) {
        this.setActorName("ONG");
        this.setActorDescription("Une organisation non gouvernementale ayant pour vocation de prendre des actions de large ampleur pour l'environnement.");
        this.setActorLevel(baseLvl);
        this.setActorBudget(baseBudget);
    }

    //public method

    //create a local protected area
    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseAwareness(10*getActorLevel());
        for(Biodiversity tempBio : myIsland.getIslandBio())
        {
            tempBio.multiplyBioPop(1.2);
        }
    }

    //create a global marine protected area
    @Override
    public void useActive(Archipelago myArchipelago) {
        for(Island tempIsland : myArchipelago.getFederateIslands())
        {
            for(Biodiversity tempBio : tempIsland.getIslandBio())
            {
                tempBio.multiplyBioPop(1.2);
            }
            tempIsland.increaseAwareness(5*getActorLevel());
        }
    }

}
