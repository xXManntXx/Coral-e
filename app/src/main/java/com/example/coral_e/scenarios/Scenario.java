package com.example.coral_e.scenarios;

public abstract class Scenario {
    private String scenarioID;
    private String scenarioName;
    private String scenarioContent;

    //constructor
    public Scenario()
    {}

    //getter

    public String getScenarioID() {
        return scenarioID;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public String getScenarioContent() {
        return scenarioContent;
    }


    //setter
    public void setScenarioID(String myScenarioID) {
        scenarioID = myScenarioID;
    }

    public void setScenarioName(String myScenarioName) {
        scenarioName = myScenarioName;
    }

    public void setScenarioContent(String myScenarioContent) {
        scenarioContent = myScenarioContent;
    }
}
