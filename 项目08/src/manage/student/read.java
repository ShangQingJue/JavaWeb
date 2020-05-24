package manage.student;

import dao.factory.DAOFactory;
import daomain.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/read")
public class read extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        List<Student> students = null;
        try {
            students = DAOFactory.getIStudentDAOInstance().read(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Student student = null;
        for (Student s: students) {
            student = s;
        }
        request.setAttribute("student", student);
        request.getRequestDispatcher("../student_personal.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
