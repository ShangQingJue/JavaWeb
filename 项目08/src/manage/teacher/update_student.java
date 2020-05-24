package manage.teacher;

import dao.factory.DAOFactory;
import daomain.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/update_student")
public class update_student extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        List<Student> students = null;
        try {
            students = DAOFactory.getIStudentDAOInstance().read(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Student student: students) {
            request.setAttribute("student", student);
        }
        request.getRequestDispatcher("../UpdateForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setSid(request.getParameter("sid"));
        student.setSname(request.getParameter("sname"));
        student.setSbirthday(request.getParameter("sbirthday"));
        student.setSsex(Integer.parseInt(request.getParameter("ssex")));
        try {
            DAOFactory.getIStudentDAOInstance().update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./student_list");
    }
}
