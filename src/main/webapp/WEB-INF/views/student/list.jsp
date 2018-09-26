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
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>

<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="stud" items="${students}">
        <tr>
            <td>${stud.firstName}</td>
            <td>${stud.lastName}</td>
            <td><a href="/student/details?id=${stud.id}">Szczegóły</a></td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
