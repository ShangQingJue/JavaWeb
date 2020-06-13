<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>项目8:基于MVC的学生信息管理系统</title>
  <style>
    ul {
      list-style: none;
      padding: 0;
    }
    li {
      float: left;
      margin: 0 5px;
    }
  </style>
</head>
<body>
<h1>项目8:基于MVC的学生信息管理系统</h1>

<%
  String name = "";
  if (!session.isNew()) {
    name = (String)session.getAttribute("user_id");
    if (name != null) {
%>

<h3>当前用户：<%=name%>&nbsp;<a href="./logout">注销</a></h3>
<ul>
  <li><a href="./student.jsp">学生主页</a></li>
  <li><a href="./teacher.jsp">教师主页</a></li>
</ul>

<%      } else {
  request.getRequestDispatcher("./logout").forward(request, response);
}
} else {
%>

<ul>
  <li><a href="./student_login">学生登录</a></li>
  <li><a href="./teacher_login">教师登录</a></li>
</ul>

<%
  }
%>

</body>
</html>

