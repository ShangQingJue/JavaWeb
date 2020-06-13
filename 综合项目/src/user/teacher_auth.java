package user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/teacher.jsp", "/teacher/*"})
public class teacher_auth implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if (((String)session.getAttribute("user_id") != null) && (((String) session.getAttribute("auth")).equals("teacher"))) {
            filterChain.doFilter(request, response);
        }else {
            response.sendRedirect("./teacher_login");
        }
    }
}
