package com.example.coral_e.biodiversity;

public class MahiMahi extends Biodiversity{
    public MahiMahi(int myPopulation) {
        super("Mahi-Mahi","Grand poisson carnivore de couleur vive, prisée par les pêcheurs.","Fauna");
        setFoodValue(10);
        setTouristicValue(3);
        setBioPopulation(myPopulation);
    }
}