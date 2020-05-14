<%@ page import="java.sql.*" %>
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
    try {
        String sql = (String)request.getAttribute("sql");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaWeb?usrSSL=false&serverTimezone=UTC", "root", "123456789");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            String sid = res.getString("sid");
            String sname = res.getString("sname");
            String sbirthday = res.getString("sbirthday");
            int ssex = res.getInt("ssex");
%>
<h1>学生信息修改</h1>
<form method="post" action="./update">
    学号：<input type="text" name="sid" value="<%=sid%>" readonly><br>
    姓名：<input type="text" name="sname" value="<%=sname%>"><br>
    生日：<input type="date" name="sbirthday" value="<%=sbirthday%>"><br>
    性别：
    <%
        String checked = "checked='true'";
        String checked0 = "", checked1 = "";
        if (ssex == 0) {
            checked0 = checked;
        }
        if (ssex == 1) {
            checked1 = checked;
        }
    %>
    <input type="radio" name="ssex" value="0" <%=checked0%>>女
    <input type="radio" name="ssex" value="1" <%=checked1%>>男<br>
    <input type="submit" value="提交">&nbsp;<input type="reset" value="重置">
</form>
<%
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>
<p><a href="./index.jsp">返回首页</a></p>
</body>
</html>