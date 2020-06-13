<%@ page import="daomain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息</title>
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
    <h3>学生个人信息</h3>
    <ul>
        <li><a href="../student.jsp">返回学生主页</a></li>
    </ul>
    <br>
    <%
        request.setCharacterEncoding("utf-8");
        Student student = null;
        student = (Student)request.getAttribute("student");
    %>
    <p>学号:<%= student.getSid() %></p>
    <p>姓名:<%= student.getSname() %></p>
    <p>生日:<%= student.getSbirthday() %></p>
</body>
</html>
