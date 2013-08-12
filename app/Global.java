import com.google.inject.Guice;
import com.google.inject.Injector;
import module.ApplicationModule;
import play.GlobalSettings;

public class Global extends GlobalSettings
{
    private static final Injector INJECTOR = createInjector();

    /*
        I think this is necessary if Controller methods are not static.
        If they are not static we can inject services without using
        the requestStaticInjection method, but on the other side the
        routes file gives error in IDEA (it doesn't recognize the
        non-static methods in the controllers).
     */
    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception
    {
        return INJECTOR.getInstance(controllerClass);
    }

    private static Injector createInjector()
    {
        return Guice.createInjector(new ApplicationModule());
    }
}
