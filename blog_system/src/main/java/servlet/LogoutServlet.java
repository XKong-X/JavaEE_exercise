package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LogoutServlet
 * Package: servlet
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/29 11:28
 * @Version 1.0
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前为未登录状态");
            return;
        }
        // 把 user 中的属性删除
        session.removeAttribute("user");
        // 跳转至登录页
        resp.sendRedirect("login.html");
    }
}
