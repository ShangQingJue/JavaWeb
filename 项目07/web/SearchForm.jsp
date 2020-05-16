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
        请输入查找的相关信息：<input type="text" name="find" placeholder="学号/姓名/生日(xxxx-xx-xx)">
        <input type="submit" value="查找">&nbsp;<input type="reset" value="重置">
    </form>
    <p><a href="./index.jsp">返回首页</a></p>
</body>
</html>