package util;

import org.experis.eventsmanager.*;

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

    public static void eventAddReservation(Event event) {
        System.out.println("Adding reservation to event..");
        Reservation newReservation = reservationService.createGetReservation();

        event.addReservation(newReservation);
    }

    public static void menu() {
        System.out.println("-------------------- MENU ----------------------");
        System.out.println("Welcome to the event manager");
        System.out.println("1. Create event");
        System.out.println("2. Print events");
        System.out.println("3. Add reservation to event");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                createEvent();
                break;
            case 2:
                printEvents();
                break;
            case 3:
                System.out.println("Insert event title: ");
                Event event = DB.getEventByTitle(sc.nextLine());
                eventAddReservation(event);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }
}

