<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("name")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.sendRedirect("./loginForm_Cookie.jsp");
            }
        }
    %>
</body>
</html>
