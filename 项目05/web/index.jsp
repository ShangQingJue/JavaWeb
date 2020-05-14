<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目 5：基于 JDBC 的学生信息 CRUD </title>
    <style>
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            float: left;
            margin: 0 5px;
        }
    </style>
</head>
<body>
    <h1>项目 5：基于 JDBC 的学生信息 CRUD</h1>
    <%
        String name = "";
        if (!session.isNew()) {
            name = (String)session.getAttribute("user_id");
            if (name != null) {
    %>
    <h3>当前用户：<%=name%>&nbsp;<a href="./logout">注销</a></h3>
    <%      } else {
                request.getRequestDispatcher("./logout").forward(request, response);
            }
        } else {
    %>
    <h3><a href="./login">登录</a></h3>
    <%
        }
    %>
    <h3 >学生管理基本功能:</h3>
    <ul>
        <li><a href="./add">添加</a></li>
        <li><a href="./read">检索</a></li>
        <li><a href="./list">列表</a></li>
    </ul>
</body>
</html>
