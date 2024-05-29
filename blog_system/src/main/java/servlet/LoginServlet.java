package servlet;

import model.User;
import model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Package: servlet
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/28 16:16
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || username.length() == 0 || password == null || password.length() == 0){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码为空！");
            return;
        }
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserInfoByName(username);
        if (user == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误！");
            return;
        }
        if (!password.equals(user.getPassword())) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误！");
            return;
        }
        // 创建会话
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);
        // 跳转到主页
        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        // 会话不存在，因此是未登录状态
        if (session == null) {
            resp.setStatus(403);// 用 403 状态来触发 302 临时重定向
            return;
        }
        User user = (User) session.getAttribute("user");
        // 用户不存在，因此是未登录状态
        if (user == null) {
            resp.setStatus(403);
            return;
        }
        // 两个都存在，返回 200
        resp.setStatus(200);
    }
}
