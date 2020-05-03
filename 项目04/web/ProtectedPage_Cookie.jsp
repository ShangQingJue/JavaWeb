<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>受保护页</title>
</head>
<body>
    <%
        String name = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("name")) {
                name = cookie.getValue();
            }
        }
        if (name.equals("")) {
            response.sendRedirect("./loginForm_Cookie.jsp");
        }
    %>
    <h1>登录保护页</h1>
    <h4>欢迎<%= name %>访问本系统<a href="./logout_Cookie.jsp">【注销】</a></h4>
    <p>本页是受系统登录保护的页面，仅在你输入了正确的用户名和密码登录后才可以访问本页信息。</p>
    <p>如果你在没有登录或登录注销后看到本页信息，说明你的程序实现存在错误漏洞。</p>
</body>
</html>
