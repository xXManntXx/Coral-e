package com.example.coral_e;

import androidx.versionedparcelable.ParcelField;
import androidx.versionedparcelable.VersionedParcelize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.coral_e.actors.Actor;
import com.example.coral_e.actors.EnvironmentalAssociation;
import com.example.coral_e.actors.Farmer;
import com.example.coral_e.actors.Fisherman;
import com.example.coral_e.actors.Scientifics;
import com.example.coral_e.actors.TouristicAgency;
import com.example.coral_e.biodiversity.*;
import com.example.coral_e.events.Event;
import com.example.coral_e.laws.BeachPrivatization;
import com.example.coral_e.laws.FreeTrade;
import com.example.coral_e.laws.GreenExcursion;
import com.example.coral_e.laws.Law;
import com.example.coral_e.laws.RegulatedFishing;
import com.example.coral_e.scenarios.FortressWorld;
import com.example.coral_e.scenarios.GreatTransition;
import com.example.coral_e.scenarios.MarketForce;
import com.example.coral_e.scenarios.PolicyReform;
import com.example.coral_e.scenarios.Scenario;

import android.os.Parcel;
import android.os.Parcelable;


//each player got an island which regroup everything they possessed
@VersionedParcelize
public final class Island implements Parcelable {
    //Logs
    private static final String TAG = "Island";

    private int islandID;
    private String islandName;
    private int socialLevel;
    private int globalAwareness;
    private int islandFocus; //negative : economic growth - positive : well-being
    private int islandSpirit; //negative : individualism - positive : community
    private Scenario forecastScenario;
    private int resources;
    private int income;
    private List<Law> islandLaws = new ArrayList<Law>();
    private List<Biodiversity> islandBio = new ArrayList<Biodiversity>();
    private List<Actor> islandActors = new ArrayList<Actor>();
    private List<Event> allEvents = new ArrayList<Event>();
    private String biome; //indicate the starting components of the island
    /*BIOMES :
    TestingBiome : can change, used for test
    */
    //TODO just for presentation, to delete after (redondant with Archipelago)
    private int presentTurn;


    //Constructor
    public Island() {
        new Island("Mon île","TestingBiome");
    }

    public Island(String myIslandName,String myBiome) {
        List<String> availableBiomes = new ArrayList<String>() {
            {
                add("TestingBiome");
            }
        };
        assert (availableBiomes.contains(myBiome)) : "Unknown biome selected";
        this.islandName = myIslandName;
        this.socialLevel = 0;
        this.globalAwareness = 0;
        this.islandFocus = 0;
        this.islandSpirit = 0;
        this.resources = 0;
        this.income = 0;
        //TODO add all existing laws in islandLaws
        this.islandLaws.add(new RegulatedFishing());
        this.islandLaws.add(new BeachPrivatization());
        this.islandLaws.add(new FreeTrade());
        this.islandLaws.add(new GreenExcursion());

        //TODO add all starting biodiversity and actors regarding of the chosen biome
        if (myBiome=="TestingBiome")
        {
            this.islandActors.add(new Fisherman());
            this.islandActors.add(new TouristicAgency());
            this.islandActors.add(new Farmer());
            this.islandActors.add(new Scientifics());
            this.islandActors.add(new EnvironmentalAssociation());

            this.islandBio.add(new MahiMahi(20));
            this.islandBio.add(new BlacktipShark(5));
            this.islandBio.add(new FireCoral(10));
        }

        //TODO just for presentation, to delete after (redondant with Archipelago)
        this.presentTurn = 1;
    }

    protected Island(Parcel in) {
        islandID = in.readInt();
        islandName = in.readString();
        socialLevel = in.readInt();
        globalAwareness = in.readInt();
        islandFocus = in.readInt();
        islandSpirit = in.readInt();
        resources = in.readInt();
        income = in.readInt();
        biome = in.readString();
    }

    public static final Creator<Island> CREATOR = new Creator<Island>() {
        @Override
        public Island createFromParcel(Parcel in) {
            return new Island(in);
        }

        @Override
        public Island[] newArray(int size) {
            return new Island[size];
        }
    };

    //Getter
    public int getIslandID() {
        return islandID;
    }

    public String getIslandName() {
        return islandName;
    }

    public int getIslandFocus() {
        return islandFocus;
    }

    public int getIslandSpirit() {
        return islandSpirit;
    }

    public Scenario getForecastScenario() {
        return forecastScenario;
    }

    public int getSocialLevel() {
        return socialLevel;
    }

    public int getGlobalAwareness() {
        return globalAwareness;
    }

    public int getResources() {
        return resources;
    }

    public int getIncome() {
        return income;
    }

         //Return voted Island Laws
    public ArrayList<Law> getVotedLaws() {
        ArrayList<Law> myVotedLaws = new ArrayList<Law>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVoted()) {
                myVotedLaws.add(tempLaw);
            }
        }
        return myVotedLaws;
    }

            //Return visible Island Laws
    public ArrayList<Law> getVisibleLaws() {
        ArrayList<Law> myVisibleLaws = new ArrayList<Law>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVisible()) {
                myVisibleLaws.add(tempLaw);
            }
        }
        return myVisibleLaws;
    }

    public ArrayList<String> getLawTexts(){
        ArrayList<String> myLawTexts = new ArrayList<String>();
        for(Law tempLaw : this.getVisibleLaws())
        {
            myLawTexts.add(tempLaw.getLawName());
        }
        return myLawTexts;
    }

    public List<Biodiversity> getIslandBio() {
        return islandBio;
    }

    public List<Actor> getIslandActors() {
        return islandActors;
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public Actor getActor(Actor myActor)
    {
        try {
            for (Actor tempActor : this.islandActors) {
                if (tempActor.getClass().getSimpleName().equals(myActor.getClass().getSimpleName())) {
                    return tempActor;
                }
            }
            throw new Exception("No actor found");
        }catch (Exception myE){
        myE.printStackTrace();
        System.err.println("Caught Exception: " + myE.getMessage());
    }
        return new Actor("GoneWrong","You should not see this.") {
            @Override
            public void usePassive(Island myIsland) {
            }

            @Override
            public void useActive(Archipelago myArchipelago) {
            }

            @Override
            public void evolve(Island myIsland) {
            }
        };
    }



    //Setter
    public void setIslandID(int myIslandID) {
        this.islandID = myIslandID;
    }

    public void setSocialLevel(int mySocialLevel) {
        this.socialLevel = mySocialLevel;
    }

    public void setGlobalAwareness(int myGlobalAwareness) {
        this.globalAwareness = myGlobalAwareness;
    }

    public void setResources(int myResources) {
        this.resources = myResources;
    }

    public void setIncome(int myIncome) {
        this.income = myIncome;
    }


    //Modifier

    public void increaseIncome(int value)
    {
        this.income+=value;
    }

    public void increaseAwareness(int myValue)
    {
        this.globalAwareness+=myValue;
    }

    public void increaseSocialLvl(int myValue)
    {
        this.socialLevel+=myValue;
    }

    public void increaseFocus(int myValue)
    {
        this.islandFocus+=myValue;
    }

    public void increaseSpirit(int myValue)
    {
        this.islandSpirit+=myValue;
    }

    public void addActor(Actor myActor)
    {
        this.islandActors.add(myActor);
    }


    //Public Methods
    public void generateIncome() {
        this.resources += this.income;
    }

    public boolean isLawVoted(String searchedLawID) {
        try {
            for (Law tempLaw : this.islandLaws) {
                if (tempLaw.getLawID().equals(searchedLawID)) {
                    return tempLaw.isVoted();
                }
            }
            throw new Exception("Law not found");
        } catch (Exception myE){
            myE.printStackTrace();
            System.err.println("Caught Exception: " + myE.getMessage());
        }
        return false;
    }

    public int touristicValue()
    {
        int myTouristicValue = 0;
        for (Biodiversity tempBio : this.getIslandBio()) {
            myTouristicValue+=tempBio.getTouristicValue()*tempBio.getBioPopulation();
        }
        return myTouristicValue;
    }

    public void activateEvents(int presentTurn)
    {
        for(Event tempEvent : this.allEvents) {
            tempEvent.activate(this,presentTurn);
        }
    }

    public void sufferEvent()
    {
        List<Event> activatedEvent = new ArrayList<Event>(){};
        for(Event tempEvent : this.getAllEvents())
        {
            if(tempEvent.isActive())
            {
                activatedEvent.add(tempEvent);
            }
        }
        Event chosenEvent = activatedEvent.get(new Random().nextInt(activatedEvent.size()));
        chosenEvent.happen(this);
    }

    public void forecast()
    {
        if (this.islandFocus<0)
        {
            if (this.islandSpirit<0)
            {
                forecastScenario  = new MarketForce();
            }else
            {
                forecastScenario = new PolicyReform();
            }
        }
        else
        {
            if (this.islandSpirit<0)
            {
                forecastScenario  = new FortressWorld();
            }else
            {
                forecastScenario = new GreatTransition();
            }
        }
    }

    public void passTurn()
    {
        this.presentTurn+=1;
        this.activateEvents(this.presentTurn);
        this.sufferEvent();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(islandID);
        dest.writeString(islandName);
        dest.writeInt(socialLevel);
        dest.writeInt(globalAwareness);
        dest.writeInt(islandFocus);
        dest.writeInt(islandSpirit);
        dest.writeInt(resources);
        dest.writeInt(income);
        dest.writeString(biome);
        //TODO juste for presentation, to remove caus redondant with archipelago
        dest.writeInt(presentTurn);
    }
}