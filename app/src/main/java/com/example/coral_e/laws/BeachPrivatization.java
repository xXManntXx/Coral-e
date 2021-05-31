package com.example.coral_e.laws;

import com.example.coral_e.Island;

public class BeachPrivatization  extends Law{
    public BeachPrivatization() {
        super("Privatisation des plages", "Les côtés et bord de plage sont privatisées et vendues aux plus offrants");
        this.setLawID("BEACH_PRIV");
        this.makeVisible();
    }

    @Override
    void apply(Island myIsland) {
        myIsland.increaseSpirit(-5);
    }
}
