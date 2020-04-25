package servletdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("./login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        this.doGet(request, response);
    }
}
