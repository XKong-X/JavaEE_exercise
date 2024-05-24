package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: IndexServlet
 * Package: login
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/24 22:19
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取当前用户的会话对象，用来构造画面
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前还未登录，请先登录！");
            return;
        }
        // 2. 从会话中拿出之前存进去的信息
        String username = (String) session.getAttribute("username");
        Long loginTime = (Long) session.getAttribute("loginTime");
        // 3. 生成页面
        resp.setContentType("text/html; charset=utf8");
        String respBody = "欢迎用户：" + username + "登录！" + "本次登录时间为：" + loginTime;
        resp.getWriter().write(respBody);
    }
}
