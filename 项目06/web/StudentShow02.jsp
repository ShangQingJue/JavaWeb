<%@ page import="Bean01.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单提交信息</title>
    <style>
        p {
            line-height: 30px;
        }
    </style>
</head>
<%
    request.setCharacterEncoding("UTF-8");
    Student student = (Student) request.getAttribute("student");
    String hobby = "";
    if (student.getHobby() != null) {
        for (String s: student.getHobby()) {
            hobby = hobby + " " + s;
        }
    } else {
        hobby = null;
    }
%>
<body>
<h1>表单提交信息</h1>
学号：<%= student.getId() %><br>
姓名：<%= student.getName() %><br>
生日：<%= student.getBirthday() %><br>
性别：<%= student.getSex() %><br>
体育爱好：<%= hobby %><br><br>
<a href="./index.jsp">返回首页</a>
</body>
</html>
