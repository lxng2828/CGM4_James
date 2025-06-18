<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi USD sang VNĐ</h1>
<form action="convert" method="post">
    <label for="rate">Tỉ giá (1 USD = ? VNĐ):</label><br>
    <input type="number" id="rate" name="rate" step="any" required value="25000"><br><br>

    <label for="usd">Số tiền (USD):</label><br>
    <input type="number" id="usd" name="usd" step="any" required><br><br>

    <input type="submit" value="Chuyển đổi">
</form>
</body>
</html>
