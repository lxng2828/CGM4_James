<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Máy tính cá nhân</title>
    <style>
        .error {
            color: red;
        }

        .result {
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Calculator</h2>

<form action="calculate" method="post">
    <input type="number" name="firstNumber" value="${firstNumber}" step="any" required>
    <input type="number" name="secondNumber" value="${secondNumber}" step="any" required>
    <br><br>
    <button type="submit" name="operator" value="Addition(+)">Addition(+)</button>
    <button type="submit" name="operator" value="Subtraction(-)">Subtraction(-)</button>
    <button type="submit" name="operator" value="Multiplication(X)">Multiplication(X)</button>
    <button type="submit" name="operator" value="Division(/)">Division(/)</button>
</form>

<hr>

<c:if test="${not empty result}">
    <h3>Result: <span class="result">${result}</span></h3>
</c:if>

<c:if test="${not empty error}">
    <h3 class="error">Error: ${error}</h3>
</c:if>

</body>
</html>