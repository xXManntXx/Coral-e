package com.example.coral_e;

abstract class Event {
    private String eventName;
    private String eventContent;

    public Event(String eventName, String eventContent) {
        this.eventName = eventName;
        this.eventContent = eventContent;
    }

    //getter

    public String getEventName() {
        return eventName;
    }

    public String getEventContent() {
        return eventContent;
    }
}
