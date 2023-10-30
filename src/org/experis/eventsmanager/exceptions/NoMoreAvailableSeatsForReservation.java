package org.experis.eventsmanager.exceptions;

public class NoMoreAvailableSeatsForReservation extends Exception {
    public NoMoreAvailableSeatsForReservation(String message) {
        super(message);
    }

    public NoMoreAvailableSeatsForReservation() {
        super("No more seats available for event...");
    }

}
