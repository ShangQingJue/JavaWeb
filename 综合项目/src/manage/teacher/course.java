package manage.teacher;

import dao.factory.DAOFactory;
import daomain.Course;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/course")
public class course extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String tid = request.getParameter("id");
        List<Course> courses = null;
        try {
            courses = DAOFactory.getICourseDAOInstance().read(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("../teacher_course.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
