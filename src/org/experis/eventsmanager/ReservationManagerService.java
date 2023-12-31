package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.NoMoreAvailableSeatsForReservation;

import java.util.Scanner;

public class ReservationManagerService implements IReservationManagerService {

    Scanner scanner = new Scanner(System.in);

    @Override
    public Reservation createGetReservation(Event event) throws NoMoreAvailableSeatsForReservation {

        System.out.println("Creating reservation..");
        Reservation reservation = new Reservation();

        System.out.println("Insert number of persons to create reservations: ");
        int persons = scanner.nextInt();
        if (event.getAvailableSeats() < persons){
            throw new NoMoreAvailableSeatsForReservation();
        }

        // set reserved seats
        reservation.setSeats(persons);
        scanner.nextLine(); // consume char
        // set reserved names
        for (int i = 1; i <= persons; i++) {
            System.out.printf("Insert name of %s person: ", i);
            reservation.names.add(scanner.nextLine());
        }

        return reservation;
    }
}
