package StudentManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import java.io.IOException;
import java.sql.*;

@WebServlet("/add")
public class Create extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./StudentForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("sname");
        String birthday = request.getParameter("sbirthday");
        int sex = Integer.parseInt(request.getParameter("ssex"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaWeb?usrSSL=false&serverTimezone=UTC", "root", "123456789");
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT MAX(sid) FROM student");
            String sid = "";
            while (res.next()) {
                sid = res.getString("MAX(sid)");
                String[] strs = sid.split("[^0-9]");
                String numStr = strs[strs.length-1];
                int n = numStr.length();
                int num = Integer.parseInt(numStr)+1;
                String added = String.valueOf(num);
                n = Math.min(n, added.length());
                sid = sid.subSequence(0, sid.length()-n)+added;
            }
            PreparedStatement pst = con.prepareStatement("INSERT INTO student(sid,sname,sbirthday,ssex) VALUES(?,?,?,?)");
            pst.setString(1, sid);
            pst.setString(2, name);
            pst.setString(3, birthday);
            pst.setInt(4, sex);
            pst.executeUpdate();
            pst.close();
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("./list");
        }
    }
}
