package org.experis.eventsmanager.utils;

import org.experis.eventsmanager.DB;
import org.experis.eventsmanager.Event;

import java.util.HashMap;

public class DBUtil {

    private static int NEXT_ID = getStartingId();

    public static boolean isUnique(Event event) {
        return ! DB.get().containsKey(event.getId());
    }

    public static int getNextId() {
        return NEXT_ID++;
    }

    private static int getStartingId() {
        HashMap<Integer, Event> map = DB.get();
        if (map.isEmpty()) {
            return 1;
        }

        /*  ensures that each time you start your application,
         * NEXT_ID picks up from where it left off,
         * given that all events are loaded into the HashMap upon startup.
         */
        return map
                .keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0) + 1;
    }

}
