import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {

    final private static List<Record> records = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        String infoMessage = null;

        try {
            float weight = Float.parseFloat(req.getParameter("weight").replace(',', '.'));
            float height = Float.parseFloat(req.getParameter("height").replace(',', '.'));
            Record record = new Record(weight, height);
            records.add(record);
            infoMessage = String.format("Your BMI is %.1f. Category is %s", record.getBmi(), record.getCategory());
        } catch (NumberFormatException e) {
            infoMessage = "Number format exception";
        } catch (Exception e) {
            infoMessage = "Unidentified exception";
        }

        printHtmlResponse(printWriter, infoMessage);

    }

    private static class Record {

        final private Calendar calendar;
        final private float weight;
        final private float height;
        final private float bmi;
        final private String category;

        public Record(float weight, float height) {
            this.calendar = Calendar.getInstance();
            this.weight = weight;
            this.height = height;
            this.bmi = BmiServlet.getBmi(weight, height);
            this.category = BmiServlet.getCategory(bmi);
        }

        public Calendar getCalendar() {
            return calendar;
        }

        public float getWeight() {
            return weight;
        }

        public float getHeight() {
            return height;
        }

        public float getBmi() {
            return bmi;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return String.format(
                    "<tr>" +
                            "<td>%1$td.%1$tm.%1$ty %1$tT</td>" +
                            "<td>%2$.2f</td>" +
                            "<td>%3$.2f</td>" +
                            "<td>%4$.2f</td>" +
                            "<td>%5$s</td>" +
                            "</tr>",
                    calendar, weight, height, bmi, category
            );
        }
    }

    private void printHtmlResponse(PrintWriter out, String infoMessage) {
        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Body Mass Index calculator</h2>\n");
        printInputForm(out);
        out.format("<h3>%s</h3>%n", infoMessage);
        printTable(out);
        out.println("</body>\n" +
                "</html>");
    }

    private void printInputForm(PrintWriter out) {
        out.println("<form name=\"mbiServlet\" method=\"GET\" action=\"BmiServlet\">\n" +
                "    weight          : <input type=\"text\" name=\"weight\"/> <br/>\n" +
                "    height       : <input type=\"text\" name=\"height\"/> <br/>\n" +
                "    <input type=\"submit\" value=\"submit\"/>\n" +
                "</form>");
    }

    private void printTable(PrintWriter out) {
        out.println("<table border=\"1\">\n" +
                "   <caption>History</caption>\n" +
                "   <tr>\n" +
                "    <th>Date vs Time</th>\n" +
                "    <th>Weight</th>\n" +
                "    <th>Height</th>\n" +
                "    <th>BMI</th>\n" +
                "    <th>Category</th>\n" +
                "   </tr>");
        records.stream()
                .sorted((r1, r2) -> r2.getCalendar().compareTo(r1.getCalendar()))
                .forEach(r -> out.println(r.toString()));
        out.println("</table>");
    }

    private static float getBmi(float weight, float height) {
        return weight / (height * height);
    }

    private static String getCategory(float bmi) {
        if (bmi < 15) return "Very severely underweight";
        else if (bmi < 16) return "Severely underweight";
        else if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal (healthy weight) ";
        else if (bmi < 30) return "Overweight ";
        else if (bmi < 35) return "Obese Class I (Moderately obese) ";
        else if (bmi < 40) return "Obese Class II (Severely obese) ";
        else if (bmi < 45) return "Obese Class III (Very severely obese) ";
        else if (bmi < 50) return "Obese Class IV (Morbidly Obese) ";
        else if (bmi < 60) return "Obese Class V (Super Obese) ";
        else return "Obese Class VI (Hyper Obese) ";

    }

}
