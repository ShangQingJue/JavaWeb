<%@ page import="daomain.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师个人信息</title>
    <style>
        ul {
            list-style: none;
        }
        li {
            float: left;
            margin: 0 5px;
        }
    </style>
</head>
<body>
<h3>教师个人信息</h3>
<ul>
    <li><a href="../teacher.jsp">返回教师主页</a></li>
</ul>
<br>
<%
    request.setCharacterEncoding("utf-8");
    Teacher teacher = null;
    teacher = (Teacher) request.getAttribute("teacher");
%>
<p>编号:<%= teacher.getTid() %></p>
<p>姓名:<%= teacher.getTname() %></p>
</body>
</html>
