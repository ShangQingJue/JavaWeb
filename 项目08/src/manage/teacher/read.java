package manage.teacher;

import dao.factory.DAOFactory;
import daomain.Teacher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/read")
public class read extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String tid = request.getParameter("id");
        List<Teacher> teachers = null;
        try {
            teachers = DAOFactory.getITeacherDAOInstance().read(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Teacher teacher = null;
        for (Teacher t: teachers) {
            teacher = t;
        }
        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("../teacher_personal.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
