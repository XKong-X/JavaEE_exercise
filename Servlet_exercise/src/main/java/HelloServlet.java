import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: HelloServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/19 17:12
 * @Version 1.0
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显性的告诉浏览器编码格式
        resp.setContentType("text/html; charset=utf-8");
        // 打印在 tomcat 控制台上
        System.out.println("你好 servlet");
        // 显示到浏览器页面上
        resp.getWriter().write("你好 servlet");
    }
}
