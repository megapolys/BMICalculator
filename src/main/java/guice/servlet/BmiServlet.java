package guice.servlet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import data.service.BmiRecordService;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class BmiServlet extends HttpServlet {

    @Inject
    private Injector injector;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException, ServletException {

        BmiRecordService bmiRecordService = injector.getInstance(BmiRecordService.class);
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        bmiRecordService.add(weight, height);
        req.setAttribute("records", bmiRecordService.getBmiRecords());
        req.getRequestDispatcher("/jsp/bmi/index.jsp").forward(req, resp);
    }
}
