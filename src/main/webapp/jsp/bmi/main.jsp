<%@ page import="com.google.inject.Injector,data.service.BmiRecordService" %>
<%@ page import="data.valueobjects.BmiRecord" %>
<%@ page import="guice.servlet.module.MyServletModule" %>
<%@ page import="java.util.List" %>

<html>

<head>
    <title>Auto Refresh Header Example</title>
</head>

<body>
<div style="text-align: center;">

    <h2>Body Mass Index calculator</h2>

    <jsp:include page="form.jsp"/>
    <br/>

    <table width="100%" border="1" align="center">
        <tr bgcolor="#949494">
            <th>Date vs Time</th>
            <th>Weight</th>
            <th>Height</th>
            <th>BMI</th>
            <th>Category</th>
        </tr>
        <%
            Injector injector = MyServletModule.getInjector();
            BmiRecordService bmiRecordService = injector.getInstance(BmiRecordService.class);
            List<BmiRecord> records = bmiRecordService.getBmiRecords();
            records.sort((r1, r2) -> r2.getCalendar().compareTo(r1.getCalendar()));
            for (BmiRecord r : records) {
                out.print(String.format("<tr>" +
                                "<td>%1$td.%1$tm.%1$ty %1$tT</td>" +
                                "<td>%2$.2f</td>" +
                                "<td>%3$.2f</td>" +
                                "<td>%4$.2f</td>" +
                                "<td>%5$s</td>" +
                                "</tr>",
                        r.getCalendar(), r.getWeight(), r.getHeight(), r.getBmi(), r.getCategory()
                        )
                );
            }
        %>
    </table>
</div>

</body>
</html>