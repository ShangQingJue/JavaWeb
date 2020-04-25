package demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/studentInformation2")
public class student3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>显示提交信息页面</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>表单提交信息</h1>\n" +
                "    <p>学号：" + request.getAttribute("id") + "</p>\n" +
                "    <p>姓名：" + request.getAttribute("name") + "</p>\n" +
                "    <p>生日：" + request.getAttribute("birthday") + "</p>\n" +
                "    <p>性别：" + request.getAttribute("sex") + "</p>\n" +
                "    <p>爱好：" + request.getAttribute("hobby") + "</p>\n" +
                "</body>\n" +
                "</html>";
        out.write(html);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
