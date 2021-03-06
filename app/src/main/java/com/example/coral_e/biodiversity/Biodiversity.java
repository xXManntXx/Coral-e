package com.example.coral_e.biodiversity;

import java.util.ArrayList;
import java.util.List;

/*
---Biodiversity---
Physical in game tokens representing portion of total bio population
*/


public abstract class Biodiversity {
    private String bioID ; //unique ID to easily identify each element
    private String bioName ;
    private String bioDescription ;
    private int bioPopulation;
    private int touristicValue = 0 ; //to be determined by the subclass
    private int foodValue = 0 ; //to be determined by the subclass
    private String realm; //can either be "Fauna", "Flora", "Coral"

    public Biodiversity(String myBioName, String myBioDescription,String myRealm) {
        List<String> availableRealms = new ArrayList<String>() {
            {
                add("Coral");
                add("Fauna");
                add("Flora");
            }
        };
        assert (availableRealms.contains(myRealm)) : "Bio-object does not belong to any valid realm";
        this.bioName = myBioName;
        this.bioDescription = myBioDescription;
        this.realm = myRealm;
    }

    //getter


    public String getBioID() {
        return bioID;
    }

    public String getBioName() {
        return bioName;
    }

    public String getBioDescription() {
        return bioDescription;
    }

    public int getBioPopulation() {
        return bioPopulation;
    }

    public int getTouristicValue() {
        return touristicValue;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public String getRealm() {
        return realm;
    }

    //setter
    protected void setBioID(String myBioID) {
        bioID = myBioID;
    }

    public void setTouristicValue(int myTouristicValue) {
        this.touristicValue = myTouristicValue;
    }

    public void setFoodValue(int myFoodValue) {
        this.foodValue = myFoodValue;
    }

    public void setBioPopulation(int myBioPopulation) {
        this.bioPopulation = myBioPopulation;
    }

    //modifier
    public  void multiplyBioPop(double value) {
        this.bioPopulation=(int)(this.bioPopulation*value);
    }

    public void lowerBioPopulation(int value)
    {
        this.bioPopulation-=value;
    }
}
