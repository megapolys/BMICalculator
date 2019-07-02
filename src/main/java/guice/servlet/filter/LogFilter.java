package guice.servlet.filter;

import com.google.inject.Singleton;

import javax.servlet.*;
import java.util.*;

@Singleton
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws java.io.IOException, ServletException {

        String ipAddress = request.getRemoteAddr();

        System.out.format("IP %s, Time %tr\n", ipAddress, Calendar.getInstance());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}