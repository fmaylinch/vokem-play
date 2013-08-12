package controllers;

import com.google.inject.Inject;
import model.Event;
import play.*;
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

}
