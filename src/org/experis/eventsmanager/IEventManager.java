package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.DuplicateIdException;
import org.experis.eventsmanager.exceptions.EventNotFoundException;

public interface IEventManager {
    void create(Event event) throws DuplicateIdException;
    boolean destroy(String title) throws EventNotFoundException;
}
