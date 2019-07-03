package guice.servlet.listner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import data.guice.BmiModule;
import guice.servlet.module.MyServletModule;

public class ServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new MyServletModule(), new BmiModule());
    }

}
