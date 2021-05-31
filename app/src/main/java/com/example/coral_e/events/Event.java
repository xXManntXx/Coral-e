package com.example.coral_e.events;

import com.example.coral_e.Island;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private String eventName;
    private String eventContent;
    private boolean isActive;
    private List<Integer>  eventTurn = new ArrayList<Integer>(); //can contain 1, 2 or 3

    public Event(String myEventName, String myEventContent) {
        this.eventName = myEventName;
        this.eventContent = myEventContent;
        this.isActive = false;
        //eventTurn must be initiated in subclasses
    }

    //getter

    public String getEventName() {
        return eventName;
    }

    public String getEventContent() {
        return eventContent;
    }

    public List<Integer> getEventTurn() {
        return eventTurn;
    }

    public boolean isActive() {
        return isActive;
    }

    //setter
    protected void setEventTurn(List<Integer> myEventTurn) {
        this.eventTurn = myEventTurn;
    }

    protected void setActive(boolean active) { this.isActive = active;}

    //public Method
    public boolean isItTime(Integer actualTurn)
    {
        return this.eventTurn.contains(actualTurn);
    }

    abstract public void happen(Island myIsland);

    abstract public void activate(Island myIsland, int currentTurn);
}
