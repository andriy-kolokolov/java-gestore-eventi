package org.experis.eventsmanager.exceptions;

public class DuplicateIdException extends Exception {

    public DuplicateIdException(String message) {
        super(message);
    }

    public DuplicateIdException() {
        super("Error inserting event. Duplicate ID violation.");
    }
}
