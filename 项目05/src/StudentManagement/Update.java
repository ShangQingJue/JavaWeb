package StudentManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String sql = "SELECT * FROM student WHERE sid='" + id + "'";
        request.setAttribute("sql", sql);
        request.getRequestDispatcher("./UpdateForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sbirthday = request.getParameter("sbirthday");
        int ssex = Integer.parseInt(request.getParameter("ssex"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaWeb?usrSSL=false&serverTimezone=UTC", "root", "123456789");
            Statement stm = con.createStatement();
            String sql = "UPDATE student SET sname='" + sname + "',sbirthday='" + sbirthday + "',ssex=" + ssex + " WHERE sid='" + sid + "'";
            stm.executeUpdate(sql);
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("./list");
        }
    }
}
