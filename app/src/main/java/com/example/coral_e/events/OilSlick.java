package com.example.coral_e.events;

import com.example.coral_e.Island;
import com.example.coral_e.biodiversity.Biodiversity;
import com.example.coral_e.scenarios.MarketForce;

import java.util.Arrays;
import java.util.List;

public class OilSlick extends Event{
    public OilSlick() {
        super("Marée noire", "Un bâteau vient de s'échouer sur le récif, déversant son pétrole dans le lagon et sur la berge");
        List<Integer> eventTurns = Arrays.asList(1,2,3);
        setEventTurn(eventTurns);
    }

    @Override
    public void happen(Island myIsland) {
        for (Biodiversity tempBio : myIsland.getIslandBio())
        {
            tempBio.multiplyBioPop(0.7);
        }
    }

    @Override
    public void activate(Island myIsland, int currentTurn) {
        this.setActive(myIsland.getForecastScenario() instanceof MarketForce);
    }
}
