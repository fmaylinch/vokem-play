package controllers;

import com.google.inject.Inject;
import model.Event;
import org.codehaus.jackson.JsonNode;
import play.*;
import play.libs.Json;
import play.mvc.*;

import services.EventService;
import views.html.*;

import java.util.List;

public class Application extends Controller {

    @Inject
    private static EventService eventService;

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result test() {
        return ok(test.render());
    }

    public static Result events()
    {
        final List<Event> eventList = eventService.findEvents();
        return ok(events.render(eventList));
    }

    public static Result eventsApi()
    {
        final List<Event> eventList = eventService.findEvents();
        final JsonNode jsonNode = Json.toJson(eventList);
        return ok(jsonNode);
    }

}
