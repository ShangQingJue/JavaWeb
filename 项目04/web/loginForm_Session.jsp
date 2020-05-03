<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基于Session的用户登录页面</title>
</head>
<body>
    <%
        String ErrorMessages = "";
        if (request.getMethod().equals("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("123456")) {
                session.setAttribute("name", username);
                response.sendRedirect("./ProtectedPage_Session.jsp");
            }
            else {
                ErrorMessages = "用户名或密码错误，请重新输入！";
            }
        }
    %>

    <h1>用户登录</h1>
    <%= ErrorMessages %>
    <form method="POST" action="./loginForm_Session.jsp">
        用户:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <button type="reset">重填</button>&nbsp;&nbsp;
        <button type="submit">登录</button>
    </form>
</body>
</html>
