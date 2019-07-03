<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">

<form method="get" action="index.jsp">
    Weight : <input type="text" name="weight"/>
    Height : <input type="text" name="height"/>
    <input type="submit" value="Submit"/>
</form>

<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Date</th>
        <th>Weight</th>
        <th>Height</th>
        <th>BMI</th>
        <th>Category</th>
    </tr>
    <jsp:useBean id="records" scope="request" type="java.util.List<data.valueobjects.BmiRecord>"/>
<c:forEach var="record" items="${records}">
    <tr>
        <td>${record.calendar.time}</td>
        <td><fmt:formatNumber value="${record.weight}" maxFractionDigits="2" minFractionDigits="0"/></td>
        <td><fmt:formatNumber value="${record.height}" maxFractionDigits="2" minFractionDigits="0"/></td>
        <td><fmt:formatNumber value="${record.bmi}" maxFractionDigits="2" minFractionDigits="0"/></td>
        <td>${record.category}</td>
    </tr>
</c:forEach>
</div>
</body>
</html>
