package com.example.coral_e.laws;

import com.example.coral_e.Island;

public class RegulatedFishing extends Law{
    public RegulatedFishing() {
        super("Pêche régulée", "Vous régulé la pêche, interdisant les pratiques destructrices.");
        this.setLawID("REG_FISHING");
        this.makeVisible();
    }

    @Override
    void apply(Island myIsland) {
        if (myIsland.getGlobalAwareness()<5)
        {
            myIsland.increaseSocialLvl(-5);
        }
        myIsland.increaseAwareness(5);
        myIsland.increaseSpirit(5);
    }
}
