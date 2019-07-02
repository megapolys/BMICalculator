package guice.servlet.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;
import data.guice.BmiModule;
import guice.servlet.BmiServlet;
import guice.servlet.filter.LogFilter;

public class MyServletModule extends ServletModule {

    private final static Injector injector =
            Guice.createInjector(new MyServletModule(), new BmiModule());

    public static Injector getInjector() {
        return injector;
    }

    @Override
    protected void configureServlets() {
        filter("/*").through(LogFilter.class);

        serve("/*").with(BmiServlet.class);

        System.out.println("Servlet module processing...");
    }
}
