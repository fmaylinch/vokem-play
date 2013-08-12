package module;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import controllers.Application;
import services.EventService;
import services.EventServiceImpl;

import java.net.UnknownHostException;

public class ApplicationModule extends AbstractModule
{
    private static final String VOKEM_DB = "vokem";

    @Override
    protected void configure()
    {
        bind(EventService.class).to(EventServiceImpl.class);

        // Static injections for Play controllers.
        // We can avoid this if methods and fields in controllers are not
        // static but then the routes file gives error in IDEA...
        // See Global class too.
        requestStaticInjection(Application.class);
    }

    @Provides
    public MongoClient provideMongoClient() throws UnknownHostException
    {
        return new MongoClient();
    }

    @Provides
    @Inject
    public DB provideDB(MongoClient mongoClient)
    {
        return mongoClient.getDB(VOKEM_DB);
    }
}
