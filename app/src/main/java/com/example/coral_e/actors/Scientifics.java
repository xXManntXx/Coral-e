package com.example.coral_e.actors;

import com.example.coral_e.Archipelago;
import com.example.coral_e.Island;

public class Scientifics extends Actor{
    public Scientifics() {
        super("Laboratoire de recherche", "Lieu peuplé de scientifiques en blouse blanche, étudiant la biologie et les hommes.");
    }

    //public method

    @Override
    public void usePassive(Island myIsland) {
        myIsland.increaseAwareness(10);
        myIsland.increaseSocialLvl(10);
    }

    @Override
    public void useActive(Archipelago myArchipelago) {
        //TODO envoie un plongeur scanner l'état de la biodiversité -> permet au joueur d'avoir des conseils ou des warnings sur le futur
    }

    @Override
    public void evolve() {
        //TODO Aquarium de conservation
    }
}
