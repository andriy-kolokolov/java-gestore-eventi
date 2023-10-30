package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.NoMoreAvailableSeatsForReservation;

import java.util.ArrayList;

public class Event {
    private static int NEXT_ID = 1; // static variable to hold the next available ID
    private final int id;
    private String title;
    private String date;
    private int availableSeats;
    private int reservedSeats;
    private final ArrayList<Reservation> reservations;

    public Event() {
        this.id = NEXT_ID++;
        this.reservedSeats = 0;
        this.reservations = new ArrayList<>();
    }

    public Event(String title, String date, int availableSeats) {
        this(); // calls the default constructor
        this.title = title;
        this.date = date;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\"id\": \"" + id + "\",\n" +
                "\t\"title\": \"" + title + "\",\n" +
                "\t\"date\": \"" + date + "\",\n" +
                "\t\"availableSeats\": " + availableSeats + ",\n" +
                "\t\"reservedSeats\": " + reservedSeats + ",\n" +
                "\t\"reservations\": " + printReservations() + "\n" +
                "}";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public String printReservations() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < reservations.size(); i++) {
            sb.append("\t\t").append(reservations.get(i).toString());
            if (i < reservations.size() - 1) {
                sb.append(",\t\n");
            }
        }
        sb.append("\n\t]");
        return sb.toString();
    }

    public void addReservation(Reservation reservation) {
        try {
            if (reservation.getSeats() > availableSeats) {
                throw new NoMoreAvailableSeatsForReservation();
            }
            reservations.add(reservation);
            reservedSeats += reservation.getSeats();
            availableSeats -= reservation.getSeats();

        } catch (NoMoreAvailableSeatsForReservation e) {
            System.out.println(e.getMessage());
            System.err.printf("Failed creating new reservation for event: '%s' \n", title);
            return; // exit the method without adding the reservation to the list of reservations
        }
    }
}
