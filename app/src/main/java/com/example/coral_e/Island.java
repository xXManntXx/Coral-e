package com.example.coral_e;

import androidx.versionedparcelable.VersionedParcelize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.coral_e.actors.Actor;
import com.example.coral_e.actors.EnvironmentalAssociation;
import com.example.coral_e.actors.Farmer;
import com.example.coral_e.actors.Fisherman;
import com.example.coral_e.actors.Scientists;
import com.example.coral_e.actors.TouristicAgency;
import com.example.coral_e.biodiversity.*;
import com.example.coral_e.events.Covid19;
import com.example.coral_e.events.Event;
import com.example.coral_e.events.OilSlick;
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
import android.util.Log;


/*
---Island---
Each player got one, contains everything the player have and information about his society, politic, social etc
 */
@VersionedParcelize
public final class Island implements Parcelable {
    //Logs
    private static final String TAG = "Island";

    private int islandID;
    private String islandName;
    private int socialLevel; //use to know if the people are living well
    private int globalAwareness; //use to know if people care for biodiversity or no
    //politic information
    private int islandFocus; //negative : economic growth _ positive : well-being
    private int islandSpirit; //negative : individualism _ positive : community
    private Scenario forecastScenario;
    private String islandAppraisal; //to make previsions
    private int resources; //money
    private int income; //money gain each turn
    private List<Law> islandLaws = new ArrayList<>();
    private List<Biodiversity> islandBio = new ArrayList<>();
    private List<Actor> islandActors = new ArrayList<>();
    private List<Event> allEvents = new ArrayList<>();
    private Event sufferedEvent;
    private String biome; //indicate the starting components of the island
    /*BIOMES :
    TestingBiome : can change, used for test
    */
    //TODO just for presentation, to delete after (redondant with Archipelago)
    private int presentTurn;


    //Constructor
    public Island() {
        new Island("Mon ??le","TestingBiome");
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
        this.resources = 0; //TODO set base resources
        this.income = 0; //TODO set base income
        //TODO add all existing laws in islandLaws
        this.islandLaws.add(new RegulatedFishing());
        this.islandLaws.add(new BeachPrivatization());
        this.islandLaws.add(new FreeTrade());
        this.islandLaws.add(new GreenExcursion());

        //TODO add all starting biodiversity and actors regarding of the chosen biome
        if (myBiome.equals("TestingBiome"))
        {
            this.islandActors.add(new Fisherman());
            this.islandActors.add(new TouristicAgency());
            this.islandActors.add(new Farmer());
            this.islandActors.add(new Scientists());
            this.islandActors.add(new EnvironmentalAssociation());

            this.islandBio.add(new MahiMahi(20));
            this.islandBio.add(new BlacktipShark(5));
            this.islandBio.add(new FireCoral(10));
        }

        //TODO add all existing events
        this.allEvents.add(new Covid19());
        this.allEvents.add(new OilSlick());

        //TODO just for presentation, to delete after (redondant with Archipelago)
        this.presentTurn = 1;
    }

    //for data transfer
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

    public String getIslandAppraisal() {
        return islandAppraisal;
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
        ArrayList<Law> myVotedLaws = new ArrayList<>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVoted()) {
                myVotedLaws.add(tempLaw);
            }
        }
        return myVotedLaws;
    }

            //Return visible Island Laws
    public ArrayList<Law> getVisibleLaws() {
        ArrayList<Law> myVisibleLaws = new ArrayList<>();
        for (Law tempLaw : this.islandLaws) {
            if (tempLaw.isVisible()) {
                myVisibleLaws.add(tempLaw);
            }
        }
        return myVisibleLaws;
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
        Log.e(TAG,"Caught Exception: " + myE.getMessage());
    }
        return null;
    }

    //TODO to delete because redundant with archipelago
    public int getPresentTurn() {
        return presentTurn;
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
        this.activateEvents(this.presentTurn);
        for(Event tempEvent : this.getAllEvents())
        {
            if(tempEvent.isActive())
            {
                activatedEvent.add(tempEvent);
            }
        }
        if (activatedEvent.size()>0)
        {
            Event chosenEvent = activatedEvent.get(new Random().nextInt(activatedEvent.size()));
            chosenEvent.happen(this);
            this.sufferedEvent=chosenEvent;
        }
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

    public void makeAppraisal()
    {
        String newAppraisal = "";
        newAppraisal+="------BILAN------\n";

        newAppraisal+="__Pr??visions__\n";
        newAppraisal+="Au vu de vos choix, votre ??le se dirige vers un sc??nario de type : " + this.forecastScenario.getScenarioName();
        newAppraisal+=". \"" +  this.forecastScenario.getScenarioContent() + "\" \n";

        newAppraisal+="\n__Dr??me__\n";
        newAppraisal+="Durant ces 15 ans, votre ??le a ??t?? frapp??e par : " + this.sufferedEvent.getEventName();
        newAppraisal+=". \"" +  this.sufferedEvent.getEventContent() + "\" \n";

        newAppraisal+="\n__Population__\n";
        //social
        newAppraisal+="Votre population est ";
        if (socialLevel>11)
        {
            newAppraisal+="tr??s heureuse.";
        }
        else if (socialLevel>0)
        {
            newAppraisal+="plut??t heureuse.";
        }
        else {
            newAppraisal+="malheureuse.";
        }
        newAppraisal+="\n";
        //awareness
        if (globalAwareness>9)
        {
            newAppraisal+="Elle est profond??ment consciente du probl??me environnemental.";
        }
        else if (globalAwareness>0)
        {
            newAppraisal+="Elle ??vite de trop ab??mer l'environnement.";
        }
        else {
            newAppraisal+="Elle n'a pas conscience des enjeux environnementaux.";
        }
        newAppraisal+="\nVotre population ";
        //finance
        if (income>500)
        {
            newAppraisal+="est globalement riche.";
        }
        else if (income>200)
        {
            newAppraisal+="plut??t de classe moyenne.";
        }
        else {
            newAppraisal+="plut??t pauvre.";
        }

        newAppraisal+="\n\n__Acteurs__\n";
        newAppraisal+="Vos acteurs favoris sont : ";
        for (Actor tempActeur : islandActors)
        {
            if (tempActeur.isActorActiv()&&tempActeur.getActorBudget()>200){
                newAppraisal+="\n- " + tempActeur.getActorName();
            }
        }
        newAppraisal+="\n";

        newAppraisal+="\n__Ecosyst??me__\n";
        newAppraisal+="Autour de votre ??le vous trouverez : ";
        for (Biodiversity tempBio : islandBio)
        {
            newAppraisal+="\n- " + tempBio.getBioName() + ".\nPopulation : " + tempBio.getBioPopulation() + " millier de sp??cim??nes.";
        }

        newAppraisal+="\n\n-------------\nBon courage pour la suite de votre mandat !!";
        islandAppraisal = newAppraisal;
    }

    public void passTurn()
    {
        for (Actor tempActor : islandActors)
        {
            if(tempActor.isActorActiv())
            {
                tempActor.usePassive(this);
            }
        }
        this.forecast();
        this.activateEvents(this.presentTurn);
        this.sufferEvent();
        this.generateIncome();
        this.makeAppraisal();
        //TODO to delete, will be redundant with archipelago
        this.presentTurn+=1;
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