package guice.servlet.listner;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import guice.servlet.module.MyServletModule;

public class ServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        System.out.println("Get injector processing...");
        return MyServletModule.getInjector();
    }

}
