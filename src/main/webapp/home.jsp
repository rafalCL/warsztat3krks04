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

    <c:forEach var="sol" items="${solutions}">
        ${sol.id} <a href="/solution/details?id=${sol.id}">Szczegóły</a><br>
    </c:forEach>

<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
