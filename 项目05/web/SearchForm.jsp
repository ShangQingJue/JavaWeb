<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找学生信息界面</title>
    <style>
        form {
            line-height: 30px;
        }
    </style>
</head>
<body>
    <h1>学生信息查找</h1>
    <form method="post" action="./read">
        <p>请输入查找的相关信息：</p>
        学号：<input type="text" name="sid"><br>
        姓名：<input type="text" name="sname"><br>
        生日：<input type="date" name="sbirthday"><br>
        性别：<select name="ssex">
        <option value="2">全部</option>
        <option value="1">男</option>
        <option value="0">女</option>
    </select><br>
        <input type="submit" value="查找">&nbsp;<input type="reset" value="重置">
    </form>
    <p><a href="./index.jsp">返回首页</a></p>
</body>
</html>
