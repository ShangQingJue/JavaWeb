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
    <h1>学生信息录入</h1>
    <form method="post" action="#">
        姓名：<input type="text" name="sname"><br>
        生日：<input type="date" name="sbirthday"><br>
        性别：<input type="radio" name="ssex" value="0">女<input type="radio" name="ssex" value="1">男<br>
        <input type="submit" value="提交">&nbsp;<input type="reset" value="重置">
    </form>
    <p><a href="../teacher.jsp">返回首页</a></p>
</body>
</html>
