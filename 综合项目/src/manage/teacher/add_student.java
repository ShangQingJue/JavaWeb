package manage.teacher;

import dao.factory.DAOFactory;
import daomain.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/add_student")
public class add_student extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("../StudentForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sname = request.getParameter("sname");
        String sbirthday = request.getParameter("sbirthday");
        int ssex = Integer.parseInt(request.getParameter("ssex"));
        Student student = new Student();
        try {
            student.setSid(DAOFactory.getIStudentDAOInstance().getNewSid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setSname(sname);
        student.setSbirthday(sbirthday);
        student.setSsex(ssex);
        try {
            DAOFactory.getIStudentDAOInstance().create(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./student_list");
    }
}
