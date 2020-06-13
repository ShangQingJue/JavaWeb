package user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/teacher_login")
public class teacher_login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("./teacher_login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("t000000001") && password.equals("123456")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_id", username);
            session.setAttribute("auth", "teacher");
            response.sendRedirect("./teacher.jsp");
        }else {
            String error = "用户或密码错误!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("./teacher_login.jsp").forward(request, response);
        }
    }
}
