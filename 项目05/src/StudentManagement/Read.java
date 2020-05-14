package StudentManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/read")
public class Read extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./SearchForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sbirthday = request.getParameter("sbirthday");
        String ssex = request.getParameter("ssex");
        String sql = "SELECT * FROM student WHERE ";
        if (sid.equals("") && sname.equals("") && sbirthday.equals("") && ssex.equals("2")) {
            sql = "SELECT * FROM student";
        }else {
            String[] search = new String[4];
            int count = 0;
            if (!sid.equals("")) {
                search[count] = "sid='" + sid + "'";
                count += 1;
            }
            if (!sname.equals("")) {
                search[count] = "sname='" + sname + "'";
                count += 1;
            }
            if (!sbirthday.equals("")) {
                search[count] = "sbirthday='" + sbirthday + "'";
                count += 1;
            }
            if (!ssex.equals("2")) {
                search[count] = "ssex=" + ssex;
                count += 1;
            }
            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    sql = sql + search[i];
                }else {
                    sql = sql + " AND " + search[i];
                }
            }
        }
        request.setAttribute("sql", sql);
        request.getRequestDispatcher("./StudentList.jsp").forward(request, response);
    }
}
