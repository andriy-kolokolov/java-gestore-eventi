package util;

import org.experis.eventsmanager.*;
import org.experis.eventsmanager.exceptions.EventNotFoundException;
import org.experis.eventsmanager.exceptions.NoMoreAvailableSeatsForReservation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {

    static EventManagerService eventService = new EventManagerService();
    static ReservationManagerService reservationService = new ReservationManagerService();

    static Scanner sc = new Scanner(System.in);


    public static void createEvent() {
        eventService.createEvent();
    }

    public static void printEvents() {
        System.out.println("Printing events.. ");
        DBUtil.printEvents();
    }

    public static void eventAddReservation() {
        System.out.println("Insert event title: ");
        try {
            Event event = DB.getEventByTitle(sc.nextLine());

            System.out.println("Adding reservation to event..");
            Reservation reservation = reservationService.createGetReservation(event);

            event.addReservation(reservation);

        } catch (EventNotFoundException | NoMoreAvailableSeatsForReservation e) {
            System.err.println(e.getMessage());
            System.err.println("Error adding reservation");
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("-------------------- MENU ----------------------");
            System.out.println("Welcome to the event manager");
            System.out.println("1. Create event");
            System.out.println("2. Print events");
            System.out.println("3. Add reservation to event");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            try {
                switch (choice) {
                    case 1:
                        createEvent();
                        break;
                    case 2:
                        printEvents();
                        break;
                    case 3:
                        eventAddReservation();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input value type");
            }
        }
    }
}

