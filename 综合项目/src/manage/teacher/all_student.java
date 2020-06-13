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

@WebServlet("/teacher/student_list")
public class all_student extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<Student> students = null;
        try {
            students = DAOFactory.getIStudentDAOInstance().all();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("../StudentList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
