package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.NoMoreAvailableSeatsForReservation;

public interface IReservationManagerService {
    public Reservation createGetReservation(Event event) throws NoMoreAvailableSeatsForReservation;
}
