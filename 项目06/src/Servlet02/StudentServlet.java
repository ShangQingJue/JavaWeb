package Servlet02;

import Bean01.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentShow02")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String[] hobby = request.getParameterValues("hobby");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setBirthday(birthday);
        student.setSex(sex);
        student.setHobby(hobby);
        request.setAttribute("student", student);
        request.getRequestDispatcher("./StudentShow02.jsp").forward(request, response);
    }
}
