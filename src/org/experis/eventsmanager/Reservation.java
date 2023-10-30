package org.experis.eventsmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private int seats;
    public ArrayList<String> names;

    public Reservation() {
        names = new ArrayList<>();
    }

    /**************************************************
    * create reservation for N persons
    **************************************************/
    public void create(int persons) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= persons; i++) {
            System.out.printf("Insert %s person name", i);
            names.add(sc.nextLine());
            seats++;
        }
        sc.close();
    }

    public int getSeats() {
        return seats;
    }

    public ArrayList<String> getNames() {
        return names;
    }
}
