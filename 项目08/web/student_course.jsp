<%@ page import="java.util.List" %>
<%@ page import="daomain.SC" %>
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
        <li><a href="../student.jsp">返回学生主页</a></li>
    </ul>
    <br>
    <table>
        <tr>
            <td>学号</td>
            <td>课程编号</td>
        </tr>
        <%
            request.setCharacterEncoding("utf-8");
            List<SC> scs = null;
            scs = (List<SC>)request.getAttribute("scs");
            for (SC sc: scs) {
        %>
        <tr>
            <td><%= sc.getSid() %></td>
            <td><%= sc.getCid() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
