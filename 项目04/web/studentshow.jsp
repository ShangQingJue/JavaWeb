<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单提交信息</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String birthday = request.getParameter("birthday");
    String sex = request.getParameter("sex");
    String[] hobbys = request.getParameterValues("hobby");
    String hobby = "";
    for (int i = 0; i < hobbys.length; i++) {
        hobby = hobby + hobbys[i] + " ";
    }
%>
    <h1>表单提交信息</h1>
    <p>学号:&nbsp;<%=id%></p>
    <p>姓名:&nbsp;<%=name%></p>
    <p>生日:&nbsp;<%=birthday%></p>
    <p>性别:&nbsp;<%=sex%></p>
    <p>爱好:&nbsp;<%=hobby%></p>
</body>
</html>
