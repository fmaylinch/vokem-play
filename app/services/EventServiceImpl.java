package services;

import com.google.inject.Inject;
import com.mongodb.*;
import model.Event;
import util.Function;
import util.MongoUtil;

import java.util.List;

public class EventServiceImpl implements EventService
{
    public static final String EVENTS_COLLECTION = "events";

    private final DBCollection eventsCol;

    @Inject
    public EventServiceImpl(DB vokemDb)
    {
        eventsCol = vokemDb.getCollection(EVENTS_COLLECTION);
    }

    @Override
    public List<Event> findEvents()
    {
        try (DBCursor cursor = eventsCol.find())
        {
            return MongoUtil.convert(cursor, EVENT_CONVERTER);
        }
    }

    private static final Function<DBObject,Event> EVENT_CONVERTER = new Function<DBObject, Event>() {
        @Override
        public Event apply(DBObject dbObject) {
            return new Event((String) dbObject.get("title"));
        }
    };
}
