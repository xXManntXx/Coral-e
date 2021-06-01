package com.example.coral_e.laws;

import com.example.coral_e.Island;

public class FreeTrade extends Law{
    public FreeTrade() {
        super("Libre-échange", "Ouvrir les frontières, enlever les taxes douanières.");
        this.setLawID("FREE_TRADE");
        this.makeVisible();
    }

    @Override
    public void apply(Island myIsland) {
        myIsland.increaseFocus(-5);
    }
}
