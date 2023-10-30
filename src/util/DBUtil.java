package util;

import org.experis.eventsmanager.DB;
import org.experis.eventsmanager.Event;

import java.util.HashMap;

public class DBUtil {
    public static void printEvents() {
        HashMap<Integer, Event> eventsData = DB.get();

        if (!eventsData.isEmpty()) {
            System.out.println("----------------- EVENTS -----------------------");
            for (Event event : eventsData.values()) {
                System.out.println(event.toString());
            }
            System.out.println("------------------------------------------------");
        } else {
            System.err.println("EVENTS DATA IS EMPTY");
        }

    }

}
