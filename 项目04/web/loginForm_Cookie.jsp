<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Cookie的用户登录页面</title>
</head>
<body>
    <%
        if (request.getMethod().equals("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("123456")) {
                Cookie cookie = new Cookie("name", username);
                cookie.setMaxAge(60 * 5);
                response.addCookie(cookie);
                response.sendRedirect("./ProtectedPage_Cookie.jsp");
            }
            else {
                response.sendRedirect("./loginError.jsp");
            }
        }
    %>
    <h1>用户登录</h1>
    <form method="POST" action="./loginForm_Cookie.jsp">
        用户:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <button type="reset">重填</button>&nbsp;&nbsp;
        <button type="submit">登录</button>
    </form>
</body>
</html>
