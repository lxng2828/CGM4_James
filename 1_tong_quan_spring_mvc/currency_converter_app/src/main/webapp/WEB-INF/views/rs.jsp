<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Kết quả chuyển đổi</title>
</head>
<body>
<h1>Kết quả chuyển đổi</h1>
<p>Tỉ giá: <strong><fmt:formatNumber type="number" value="${rate}" /> VNĐ / USD</strong></p>
<p>Lượng USD: <strong><fmt:formatNumber type="number" value="${usd}" /> USD</strong></p>
<hr>
<h3>Thành tiền: <fmt:formatNumber type="number" value="${vnd}" /> VNĐ</h3>
<br>
<a href="${pageContext.request.contextPath}/">Quay lại</a>
</body>
</html>