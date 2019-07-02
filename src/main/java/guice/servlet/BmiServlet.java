package guice.servlet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import data.service.BmiRecordService;

import javax.inject.Singleton;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Singleton
public class BmiServlet extends HttpServlet {

    @Inject
    Injector injector;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp){
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");

        BmiRecordService bmiRecordService = injector.getInstance(BmiRecordService.class);
        System.out.format("Bmi record service\t%s\n", bmiRecordService);
        bmiRecordService.add(weight, height);
    }
}
