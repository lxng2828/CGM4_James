<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>
      <title>Thông tin khách hàng</title>
    </head>

    <body>
      <h2>Chi tiết khách hàng</h2>
      <p>Tên:
        <c:out value="${customer.name}" />
      </p>
      <p>Tuổi:
        <c:out value="${customer.age}" />
      </p>
      <a href="${pageContext.request.contextPath}/">Quay lại danh sách</a>
    </body>

    </html>