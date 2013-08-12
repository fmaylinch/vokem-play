package services;

import model.Event;

import java.util.List;

public interface EventService {

    /** @return all {@link Event}s */
    List<Event> findEvents();
}
