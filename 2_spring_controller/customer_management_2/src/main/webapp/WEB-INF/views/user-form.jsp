<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <html>

        <head>
            <title>Form người dùng</title>
        </head>

        <body>
            <h2>
                <c:choose>
                    <c:when test="${user.id != null}">Chỉnh sửa khách hàng</c:when>
                    <c:otherwise>Thêm khách hàng mới</c:otherwise>
                </c:choose>
            </h2>

            <form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="user">
                <form:hidden path="id" />
                Tên:
                <form:input path="name" /><br />
                Tuổi:
                <form:input path="age" /><br />
                <input type="submit" value="Lưu" />
            </form:form>
        </body>

        </html>