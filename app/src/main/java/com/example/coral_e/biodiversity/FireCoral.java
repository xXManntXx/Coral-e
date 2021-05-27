package com.example.coral_e.biodiversity;

public class FireCoral extends Biodiversity{
    public FireCoral(int myPopulation) {
        super("Corail de feu","Corail commun, de forme branchue ou en plaque, peuvent percer la peau humaine au contact","Coral");
        setBioID("FIRE_CORAL");
        setFoodValue(0);
        setTouristicValue(15);
        setBioPopulation(myPopulation);
    }
}
