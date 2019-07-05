package guice.servlet;

import com.google.inject.Inject;
import data.service.BmiRecordService;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class BmiServlet extends HttpServlet {

    private BmiRecordService bmiRecordService;

    @Inject
    public void setBmiRecordService(BmiRecordService bmiRecordService) {
        this.bmiRecordService = bmiRecordService;
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException, ServletException {

        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        bmiRecordService.add(weight, height);
        req.setAttribute("records", bmiRecordService.getBmiRecords());
        req.getRequestDispatcher("/jsp/bmi/index.jsp").forward(req, resp);
    }
}
