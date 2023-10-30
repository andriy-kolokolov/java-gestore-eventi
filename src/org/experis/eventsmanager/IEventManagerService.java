package org.experis.eventsmanager;

import org.experis.eventsmanager.exceptions.DuplicateIdException;
import org.experis.eventsmanager.exceptions.EventNotFoundException;

public interface IEventManagerService {
    public void createEvent() throws DuplicateIdException;

    public boolean destroyEvent(String title) throws EventNotFoundException;
}
