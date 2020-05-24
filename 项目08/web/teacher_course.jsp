<%@ page import="java.util.List" %>
<%@ page import="daomain.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
    <style>
        ul {
            list-style: none;
        }
    </style>
</head>
<body>
<h3>课程信息</h3>
<ul>
    <li><a href="../teacher.jsp">返回教师主页</a></li>
</ul>
<br>
<table>
    <tr>
        <td>课程编号</td>
        <td>课程名称</td>
    </tr>
    <%
        request.setCharacterEncoding("utf-8");
        List<Course> courses = null;
        courses = (List<Course>)request.getAttribute("courses");
        for (Course course: courses) {
    %>
    <tr>
        <td><%= course.getCid() %></td>
        <td><%= course.getCname() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
