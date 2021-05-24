package com.example.coral_e.laws;

import com.example.coral_e.Island;

public class RegulatedFishing extends Law{
    public RegulatedFishing() {
        super("Regulated Fishing", "Vous régulé la pêche, interdisant les pratiques destructrices.");
    }

    @Override
    void apply(Island myIsland) {
        //TODO affecte le social si le niveau de global awarness n'est pas assez élevé
    }
}
