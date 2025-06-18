<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm Khách Hàng</title>
</head>
<body>
<h2>Thông tin khách hàng mới</h2>
<form:form modelAttribute="user" action="${pageContext.request.contextPath}/save" method="post">
    Tên: <form:input path="name" required="true"/><br><br>
    Tuổi: <form:input path="age" type="number" required="true"/><br><br>
    <input type="submit" value="Lưu lại">
</form:form>
<br>
<a href="${pageContext.request.contextPath}/">Quay lại danh sách</a>
</body>
</html>