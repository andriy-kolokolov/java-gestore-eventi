package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.DuplicateIdException;
import org.experis.eventsmanager.exceptions.EventNotFoundException;

import java.util.HashMap;

public class DB {

    private static final HashMap<Integer, Event> events = new HashMap<>();

    public static void addEvent(Event event) throws DuplicateIdException {
        if (events.containsKey(event.getId())) {
            throw new DuplicateIdException();
        } else {
            events.put(event.getId(), event);
        }
    }

    public static Event getEventByTitle(String title) throws EventNotFoundException {
        Event event = events.values().stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        if (event == null) {
            throw new EventNotFoundException();
        }
        return event;
    }

    public static boolean removeEventByTitle(String title) throws EventNotFoundException {
        Event eventToRemove = getEventByTitle(title);
        if (eventToRemove != null) {
            events.remove(eventToRemove.getId());
            return true;
        } else {
            throw new EventNotFoundException();
        }
    }

    public static HashMap<Integer, Event> get() {
        return events;
    }
}
