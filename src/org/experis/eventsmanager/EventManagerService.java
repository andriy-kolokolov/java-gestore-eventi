package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.DuplicateIdException;
import org.experis.eventsmanager.exceptions.EventNotFoundException;

import java.util.Scanner;

public class EventManagerService implements IEventManagerService {
    private final Scanner scanner;

    public EventManagerService() {
        this.scanner = new Scanner(System.in);
    }

    public void createEvent() {
        System.out.println("Creating event..");

        System.out.println("Insert event title: ");
        String title = scanner.nextLine();

        System.out.println("Insert event date (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        System.out.println("Insert available seats: ");
        int availableSeats = scanner.nextInt();
        scanner.nextLine(); // consume char

        Event newEvent = new Event(title, date, availableSeats);

        System.out.println(
                "[INFO] Now event has no reservations. You can add reservation later using prompt actions."
        );

        try {
            DB.addEvent(newEvent);
        } catch (DuplicateIdException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean destroyEvent(String title) throws EventNotFoundException {
        return DB.removeEventByTitle(title);
    }
}
