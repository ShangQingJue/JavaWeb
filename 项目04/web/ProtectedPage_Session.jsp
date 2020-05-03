<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>受保护页</title>
</head>
<body>
    <%
        String name = "";
        if (!session.isNew()) {
            name = (String)session.getAttribute("name");
            //response.sendRedirect("./loginForm_Session.jsp");
        }
        else {
            response.sendRedirect("./loginForm_Session.jsp");
        }
    %>
    <h1>登录保护页</h1>
    <h4>欢迎<%= name %>访问本系统<a href="./logout_Session.jsp">【注销】</a></h4>
    <p>本页是受系统登录保护的页面，仅在你输入了正确的用户名和密码登录后才可以访问本页信息。</p>
    <p>如果你在没有登录或登录注销后看到本页信息，说明你的程序实现存在错误漏洞。</p>
</body>
</html>
