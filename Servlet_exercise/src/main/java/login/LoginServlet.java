package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Package: login
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/24 12:17
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取请求传来的参数（用户名和密码）
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2. 验证用户名和密码
        if (!"zhangsan".equals(username) || !"0000".equals(password)) {
            // 登录失败
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码有误！");
            return;
        }
        // 3. 登录成功，创建会话
        HttpSession session = req.getSession(true);
        // Attribute 是键值对，存储的内容可自定义，后续跳转到其他页面也可以取出数据
        session.setAttribute("username", username);
        session.setAttribute("loginTime", System.currentTimeMillis());
        // 4. 跳转到网站首页
        resp.sendRedirect("index");
    }
}
