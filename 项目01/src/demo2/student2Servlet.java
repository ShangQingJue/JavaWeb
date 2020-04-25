package demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentInformation1")
public class student2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String birthday = request.getParameter("birthday");
        request.setAttribute("birthday", birthday);
        String sex = request.getParameter("sex");
        request.setAttribute("sex", sex);
        String[] hobbys = request.getParameterValues("hobby");
        String hobby = "";
        for (int i = 0; i < hobbys.length; i++) {
            hobby = hobby + hobbys[i] + " ";
        }
        request.setAttribute("hobby", hobby);
        request.getRequestDispatcher("./studentInformation2").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
