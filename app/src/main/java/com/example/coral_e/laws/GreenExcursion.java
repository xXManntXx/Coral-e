package com.example.coral_e.laws;

import com.example.coral_e.Island;

public class GreenExcursion extends Law {
    public GreenExcursion() {
        super("Classe verte", "Inclure dans le cursus scolaire des enfants des classes natures de sensibilisation à l'environnement.");
        this.setLawID("GREEN_CLASS");
        this.makeVisible();
    }

    @Override
    void apply(Island myIsland) {
        myIsland.increaseAwareness(10);
        myIsland.increaseFocus(5);
    }
}
