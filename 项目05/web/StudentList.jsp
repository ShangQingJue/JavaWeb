<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表信息界面 </title>
    <style>
        ul {
            list-style: none;
            padding: 0;
        }
        ul li {
            float: left;
            margin: 0 10px;
        }
        td a {
            margin: 0 3px;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>学生列表</h1>
    <ul>
        <li><a href="./add">添加学生</a></li>
        <li><a href="./read">查找学生</a></li>
        <li><a href="./index.jsp">返回首页</a></li>
    </ul>
    <div style="clear: left"></div>
    <div>
        <table>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
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
            %>
            <tr>
                <td><%=sid%></td>
                <td><%=sname%></td>
                <td><%=sbirthday%></td>
                <td><a href="./del?id=<%=sid%>">删除</a><a href="./update?id=<%=sid%>">修改</a></td>
            </tr>
            <%
                    }
                    stmt.close();
                    res.close();
                    conn.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            %>
        </table>
    </div>
</body>
</html>
