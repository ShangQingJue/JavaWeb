<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息录入</title>
    <style>
        form {
            line-height: 30px;
        }
    </style>
</head>
<body>
<h1>学生信息录入</h1>
<form method="post" action="./StudentShow02">
    学号：<input type="text" name="id"><br>
    姓名：<input type="text" name="name"><br>
    生日：<input type="date" name="birthday"><br>
    性别：<input type="radio" name="sex" value="男">男&nbsp;
    <input type="radio" name="sex" value="女">女<br>
    体育爱好：<input type="checkbox" name="hobby" value="篮球">篮球&nbsp;
    <input type="checkbox" name="hobby" value="跑步">跑步&nbsp;
    <input type="checkbox" name="hobby" value="游泳">游泳<br>
    <button type="submit">提交</button>&nbsp;
    <button type="reset">重置</button>
</form>
<a href="./index.jsp">返回首页</a>
</body>
</html>
