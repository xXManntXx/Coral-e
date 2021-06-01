package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;

public class ONG extends EnvironmentalAssociation{
    public ONG(int baseLvl) {
        this.setActorName("ONG");
        this.setActorDescription("Une organisation non gouvernementale ayant pour vocation de prendre des actions de large ampleur pour l'environnement.");
        this.setActorLevel(baseLvl);
    }

    //public method
    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseAwareness(40);
        for(Biodiversity tempBio : myIsland.getIslandBio())
        {
            tempBio.multiplyBioPop(1.2);
        }
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        for(Island tempIsland : myArchipelago.getFederateIslands())
        {
            for(Biodiversity tempBio : tempIsland.getIslandBio())
            {
                tempBio.multiplyBioPop(1.2);
            }
            tempIsland.increaseAwareness(15);
        }
    }

}
