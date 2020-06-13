<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师页面</title>
    <style>
        ul {
            list-style: none;
        }
        li {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<h1>教师页面</h1>
<%
    String name = "";
    if (!session.isNew()) {
        name = (String)session.getAttribute("user_id");
        if (name != null) {
%>

<h3>当前用户：<%= name %>&nbsp;<a href="./logout">注销</a></h3>

<%      } else {
    request.getRequestDispatcher("./logout").forward(request, response);
}
} else {
%>

<ul>
    <li><a href="./student_login">教师登录</a></li>
</ul>

<%
    }
%>
<ul>
    <li><a href="./teacher/read?id=<%= name %>">教师信息</a></li>
    <li><a href="./teacher/course?id=<%= name %>">课程信息</a></li>
    <li><a href="./teacher/add_student">添加学生</a></li>
    <li><a href="./teacher/read_student">学生查询</a></li>
    <li><a href="./teacher/student_list">全部学生</a></li>
</ul>
</body>
</html>
