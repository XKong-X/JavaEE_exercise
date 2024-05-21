import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: GetParameterServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/21 15:11
 * @Version 1.0
 */
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // query string 会被 Tomcat 自动解析成一个 map 结构
        // getParameter 就是在查询 Map<String, String> 里的内容
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("username=" + username);
        System.out.println("password=" + password);

        resp.getWriter().write("OK");
    }
}
