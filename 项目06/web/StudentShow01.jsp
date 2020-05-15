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
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="student" scope="page" class="Bean01.Student"/>
<jsp:setProperty name="student" property="*"/>

<body>
    <h1>表单提交信息</h1>
    学号：<jsp:getProperty name="student" property="id"/><br>
    姓名：<jsp:getProperty name="student" property="name"/><br>
    生日：<jsp:getProperty name="student" property="birthday"/><br>
    性别：<jsp:getProperty name="student" property="sex"/><br>
    体育爱好：<%
        String hobby = "";
        if (student.getHobby() != null) {
            for (String s: student.getHobby()) {
                hobby = hobby + " " + s;
            }
        } else {
            hobby = null;
        }
    %>
    <%=hobby%>
    <br><br>
    <a href="./index.jsp">返回首页</a>
</body>
</html>
