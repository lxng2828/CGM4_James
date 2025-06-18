<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển đơn giản</title>
</head>
<body>
<h2>Từ điển Anh – Việt</h2>

<form action="${pageContext.request.contextPath}/trans" method="post">
    <label for="engword">Nhập từ tiếng Anh:</label>
    <input type="text" name="engword" id="engword" required>
    <button type="submit">Dịch</button>
</form>

</body>
</html>
