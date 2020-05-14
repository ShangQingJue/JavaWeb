package User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/add/*", "/del/*", "/update/*", "/read/*", "/logout/*", "/list/*", "/StudentForm.jsp", "/StudentList.jsp", "/SearchForm.jsp", "/UpdateForm.jsp"})
public class Auth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if ((String)session.getAttribute("user_id") != null) {
            filterChain.doFilter(request, response);
        }else {
            response.sendRedirect("./login");
        }
    }

    @Override
    public void destroy() {

    }
}
