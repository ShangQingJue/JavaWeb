package demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Protected")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Protected_Page = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>受保护页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>登录保护页</h1>\n" +
                "    <h4>欢迎 %s 访问本系统<a href=\"./Logout\">【注销】</a></h4>\n" +
                "    <p>本页是受系统登录保护的页面，仅在你输入了正确的用户名和密码登录后才可以访问本页信息。</p>\n" +
                "    <p>如果你在没有登录或登录注销后看到本页信息，说明你的程序实现存在错误漏洞。</p>\n" +
                "</body>\n" +
                "</html>";;
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        if (id != null) {
            // Session存在
            // 显示页面
            out.write(String.format(Protected_Page, id));
        }
        else {
            // Session不存在
            // 创建Session
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("123456")) {
                // 登录成功
                session.setAttribute("id", username);
                out.write(String.format(Protected_Page, username));
            }
            else {
                response.sendRedirect("./login_error.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
