<%@ page import="java.sql.*" %>
<%@ page import="daomain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息界面</title>
    <style>
        form {
            line-height: 30px;
        }
    </style>
</head>
<body>
    <%
        Student student = (Student)request.getAttribute("student");
    %>
    <h1>学生信息修改</h1>
    <form method="post" action="./update_student">
        学号：<input type="text" name="sid" value="<%= student.getSid() %>" readonly><br>
        姓名：<input type="text" name="sname" value="<%= student.getSname() %>"><br>
        生日：<input type="date" name="sbirthday" value="<%= student.getSbirthday() %>"><br>
        性别：
        <%
            String checked = "checked='true'";
            String checked0 = "", checked1 = "";
            if (student.getSsex() == 0) {
                checked0 = checked;
            }
            if (student.getSsex() == 1){
                checked1 = checked;
            }
        %>
        <input type="radio" name="ssex" value="0" <%= checked0 %>>女
        <input type="radio" name="ssex" value="1" <%= checked1 %>>男<br>
        <input type="submit" value="提交">&nbsp;<input type="reset" value="重置">
    </form>
    <p><a href="../teacher.jsp">返回教师主页</a></p>
</body>
</html>