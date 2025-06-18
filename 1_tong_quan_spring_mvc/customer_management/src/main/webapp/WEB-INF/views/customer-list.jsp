<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table style="width:50%" border="1">
    <thead>
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.age}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/show-form">Thêm khách hàng mới</a>
</body>
</html>