<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>Danh sách khách hàng</title>
        </head>

        <body>
            <h2>Danh sách khách hàng</h2>
            <table border="1" style="width:60%">
                <tr>
                    <th>Tên</th>
                    <th>Tuổi</th>
                    <th>Hành động</th>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>
                            <c:out value="${customer.name}" />
                        </td>
                        <td>
                            <c:out value="${customer.age}" />
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/showinfo/${customer.id}">Xem</a> |
                            <a href="${pageContext.request.contextPath}/edit/${customer.id}">Sửa</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br />
            <a href="${pageContext.request.contextPath}/show-form">+ Thêm khách hàng mới</a>
        </body>

        </html>