package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

public class Fisherman extends Actor {
    public Fisherman()
    {
        super("Fisherman","Représente la pêche à la ligne par les locaux.");
    }

    //public method
    public void usePassive(Island myIsland) //generate income based on fishery
    {
        //TODO search island ecosystem for fishable fishe and generate income based on this
    }
    public void useActive(Archipelago myArchipelago) //generate income based on fishery
    {
        //TODO propose the player to select an island, an fish there
    }
}
