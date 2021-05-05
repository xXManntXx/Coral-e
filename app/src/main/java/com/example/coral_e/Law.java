package com.example.coral_e;

abstract class Law {
    private String lawName;
    private boolean isVisible;
    private boolean isVoted;
    private String lawContent;

    public Law(String myLawName, String myLawContent) {
        //Constructor
        this.lawName = myLawName;
        this.isVisible = false;
        this.isVoted = false;
        this.lawContent = myLawContent;
    }

    //getter
    public String getLawName() {
        return lawName;
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
}
