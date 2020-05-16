package StudentManagement;

import dao.factory.DAOFactory;
import daomain.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/del")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String html = "<html>\n" +
                "<head>\n" +
                "    <title>Title</title>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>学生信息删除</h1>\n" +
                "\t<form method=\"post\" action=\"./del\"> \n" +
                "\t\t学号：%s<br>\n" +
                "\t\t姓名：%s<br>\n" +
                "\t\t年龄：%s<br>\n" +
                "\t\t性别：%s<br><br>\n" +
                "\t\t是否删除该学生信息？\n" +
                "\t\t<button type=\"submit\" value=\"%s\" name=\"id\">删除</button>\n" +
                "\t\t<button type=\"button\"><a href=\"./list\">取消</a></button>\n" +
                "\t</form>\n" +
                "</body>\n" +
                "</html>";
        String sid = request.getParameter("id");
        List<Student> students = null;
        try {
            students = DAOFactory.getIStudentDAOInstance().read(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Student student: students) {
            sid = student.getSid();
            String sname = student.getSname();
            String sbirthday = student.getSbirthday();
            int ssex = student.getSsex();
            String sex = "";
            if (ssex == 1) {
                sex = "男";
            }
            if (ssex == 0) {
                sex = "女";
            }
            html = String.format(html, sid, sname, sbirthday, sex, sid);
            out.write(html);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        try {
            DAOFactory.getIStudentDAOInstance().delete(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./list");
    }
}
