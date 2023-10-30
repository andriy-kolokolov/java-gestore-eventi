package org.experis.eventsmanager.exceptions;

public class EventNotFoundException extends Exception{
    public EventNotFoundException(String message) {
        super(message);
    }

    public EventNotFoundException() {
        super("Event not found");
    }
}
