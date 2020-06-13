<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生登录</title>
    <style>
        form {
            line-height: 30px;
        }
    </style>
</head>
<body>
<h1>学生登录</h1>
<%
    request.setCharacterEncoding("utf-8");
    String ErrorMessages = (String)request.getAttribute("error");
    if (ErrorMessages != null) {
%>
<p><%=ErrorMessages%></p>
<%
    }
%>
<form method="post" action="./student_login">
    用户：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <button type="reset">重置</button>&nbsp;<button type="submit">登录</button>
</form>
<p><a href="./index.jsp">返回首页</a></p>
</body>
</html>