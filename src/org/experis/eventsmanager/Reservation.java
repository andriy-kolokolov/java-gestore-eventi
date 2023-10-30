package org.experis.eventsmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private int seats;
    public ArrayList<String> names;

    public Reservation() {
        seats = 0;
        names = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t\"seats number\": " + seats + ",\n" +
                "\t\t\"names\": [" + printNames() + "]\n" +
                "\t}";
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String printNames() {
        StringBuilder namesBuilder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            namesBuilder.append("\"").append(names.get(i)).append("\"");
            if (i < names.size() - 1) {
                namesBuilder.append(", ");
            }
        }
        return namesBuilder.toString();
    }
}
