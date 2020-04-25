package servletdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("123456")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", username);
            response.sendRedirect("./index.html");
        }else {
            response.sendRedirect("./login_error.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        this.doPost(request, response);
    }
}
