package com.example.coral_e.laws;

import com.example.coral_e.Island;

/*
---Law---
Use to determine the politic orientation of the island.
Can have diverse impact on the island.
*/

public abstract class Law {
    private String lawID; //unique ID to easily refer to sub-Law
    private String lawName;
    private int nbVote;
    private boolean isVisible;
    private boolean isVoted;
    private String lawContent;

    public Law(String myLawName, String myLawContent) {
        //Constructor
        this.lawName = myLawName;
        this.nbVote = 0 ;
        this.isVisible = false;
        this.isVoted = false;
        this.lawContent = myLawContent;
    }

    //getter
    public String getLawName() {
        return lawName;
    }

    public String getLawID() {
        return lawID;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isVoted() {
        return isVoted;
    }

    public String getLawContent() {
        return lawContent;
    }

    //useful on multiplayer mode to decide if the law have the majority
    public int getNbVote() {
        return nbVote;
    }

    //setter

    protected void setLawID(String myLawID) {
        lawID = myLawID;
    }


    //public method

    public void voteInit()
    {
        this.nbVote = 0 ;
    }

    public void gotVoted()
    {
        this.nbVote++;
    }

    //TODO to delete when data transfer will be better handled
    public void makeVoted(){
        this.isVoted=true;
    }

    public void makeVoted(Island myIsland){
        this.isVoted=true;
        this.apply(myIsland);
    }

    public void makeVisible()
    {
        this.isVisible = true;
    }

    //to be implemented by subclasses
    abstract public void apply(Island myIsland);

}
