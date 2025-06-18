<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Kết quả đăng ký</title>
        </head>

        <body>
            <h2>Đã đăng ký với nội dung sau:</h2>

            <strong>Tên:</strong> ${user.name}<br>
            <strong>Tuổi:</strong> ${user.age}<br>
            <br>
            <a href="${pageContext.request.contextPath}/">Quay lại</a>
        </body>

        </html>