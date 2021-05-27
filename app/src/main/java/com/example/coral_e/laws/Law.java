package com.example.coral_e.laws;

import com.example.coral_e.Island;

public abstract class Law {
    private String lawID;
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
    abstract void apply(Island myIsland);

}
