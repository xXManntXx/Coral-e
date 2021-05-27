package com.example.coral_e.biodiversity;

public class MahiMahi extends Biodiversity{
    public MahiMahi(int myPopulation) {
        super("Mahi-Mahi","Grand poisson carnivore de couleur vive, prisée par les pêcheurs.","Fauna");
        setBioID("MAHI_MAHI");
        setFoodValue(10);
        setTouristicValue(3);
        setBioPopulation(myPopulation);
    }
}