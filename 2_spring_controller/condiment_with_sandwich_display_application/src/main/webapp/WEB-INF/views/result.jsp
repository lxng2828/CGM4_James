<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Condiments</title>
</head>
<body>
<h2>Selected Condiments</h2>
<c:choose>
    <c:when test="${not empty condiments}">
        <ul>
            <c:forEach var="item" items="${condiments}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No condiment selected</p>
    </c:otherwise>
</c:choose>
<br>
<a href="<%= request.getContextPath() %>/">Return</a>
</body>
</html>