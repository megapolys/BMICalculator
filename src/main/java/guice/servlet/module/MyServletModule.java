package guice.servlet.module;

import com.google.inject.servlet.ServletModule;
import guice.servlet.BmiServlet;

public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/", "/index.jsp").with(BmiServlet.class);
    }
}
