package com.example.coral_e.biodiversity;

public class BlacktipShark extends Biodiversity {
    public BlacktipShark(int myPopulation) {
        super("Requin à poites noires.","Requin de récif peu dangereux, prisé des touristes.","Fauna");
        setBioID("BLACK_SHARK");
        setFoodValue(3);
        setTouristicValue(10);
        setBioPopulation(myPopulation);
    }
}
