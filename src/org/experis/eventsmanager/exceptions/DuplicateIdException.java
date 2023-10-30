package org.experis.eventsmanager.exceptions;

public class DuplicateIdException extends Exception {

    public DuplicateIdException(String message) {
        super(message);
    }

    public DuplicateIdException() {
        super("Duplicate ID violation.");
    }
}
