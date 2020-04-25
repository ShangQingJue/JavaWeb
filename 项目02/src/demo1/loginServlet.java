package demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/protected")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String protected_page = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>受保护页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>登录保护页</h1>\n" +
                "    <h4>欢迎 %s 访问本系统<a href=\"./logout\">【注销】</a></h4>\n" +
                "    <p>本页是受系统登录保护的页面，仅在你输入了正确的用户名和密码登录后才可以访问本页信息。</p>\n" +
                "    <p>如果你在没有登录或登录注销后看到本页信息，说明你的程序实现存在错误漏洞。</p>\n" +
                "</body>\n" +
                "</html>";
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            // 存在cookie
            for (Cookie cookie: cookies) {
                // 找出对应cookie并显示页面
                if (cookie.getName().equals("name")) {
                    out.write(String.format(protected_page, cookie.getValue()));
                }
            }
        }
        else {
            // 不存在cookie
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("123456")) {
                // 登录成功
                // 创建cookie
                Cookie cookie = new Cookie("name", username);
                cookie.setMaxAge(60 * 5);
                response.addCookie(cookie);
                // 显示页面
                out.write(String.format(protected_page, username));
            }
            else {
                // 登录失败
                response.sendRedirect("./error.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
