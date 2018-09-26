<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 26.09.2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<html>
<head>
    <title>Szkoła programowania</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>

<h2>Ostatnie rozwiązania</h2>
<table>
    <tr>
        <th>Lp</th>
        <th>Submission date</th>
        <th>Student</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="sol" items="${solutions}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${sol.submissionDate}</td>
            <td><a href="/student/details?id=${sol.student.id}">${sol.student.firstName} ${sol.student.lastName}</a></td>
            <td><a href="/solution/details?id=${sol.id}">Szczegóły</a></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
