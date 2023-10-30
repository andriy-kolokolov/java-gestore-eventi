package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.DuplicateIdException;
import org.experis.eventsmanager.exceptions.EventNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class Event implements IEventManager {
    private static int NEXT_ID = 1; // static variable to hold the next available ID
    private final int id;
    private String title;
    private String date;
    private final int availableSeats;
    private int reservedSeats;
    private final ArrayList<Reservation> reservations;

    public Event(String title, String date, int availableSeats) {
        this.id = NEXT_ID++; // assign the next ID and increment it
        this.title = title;
        this.date = date;
        this.availableSeats = availableSeats;
        this.reservedSeats = 0; // default value for reservedSeats
        this.reservations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public void create(Event event) throws DuplicateIdException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating event..");

        System.out.println("Insert event title: ");
        String title = sc.nextLine();

        System.out.println("Insert event date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        System.out.println("Insert available seats: ");
        int availableSeats = sc.nextInt();

        Event newEvent = new Event(title, date, availableSeats);
        DB.addEvent(newEvent);

        System.out.println("Event created with ID: " + newEvent.getId());
    }

    @Override
    public boolean destroy(String title) throws EventNotFoundException {
        return DB.removeEventByTitle(title);
    }

    public boolean createReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number of people to reserve seats: ");
        int numberOfPeople = sc.nextInt();
        // Check if enough seats are available
        if (numberOfPeople <= (availableSeats - reservedSeats)) {
            System.out.printf("Creating new reservation for event '%s' ", title);
            Reservation reservation = new Reservation();
            reservation.create(numberOfPeople);
            reservations.add(reservation);
            reservedSeats += numberOfPeople;
            return true;
        } else {
            System.out.println("Not enough seats available for this reservation.");
            return false;
        }
    }
}
