<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="daomain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表信息界面 </title>
    <style>
        ul {
            list-style: none;
            padding: 0;
        }
        ul li {
            float: left;
            margin: 0 10px;
        }
        td a {
            margin: 0 3px;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>学生列表</h1>
    <ul>
        <li><a href="./add_student">添加学生</a></li>
        <li><a href="./read_student">查找学生</a></li>
        <li><a href="../teacher.jsp">返回教师主页</a></li>
    </ul>
    <div style="clear: left"></div>
    <div>
        <table>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <%
                List<Student> students = null;
                students = (List<Student>)request.getAttribute("students");
                for (Student student: students) {
            %>
            <tr>
                <td><%= student.getSid() %></td>
                <td><%= student.getSname() %></td>
                <td><%= student.getSbirthday() %></td>
                <td><a href="./del_student?id=<%= student.getSid() %>">删除</a><a href="./update_student?id=<%= student.getSid() %>">修改</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
