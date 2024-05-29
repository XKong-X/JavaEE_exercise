package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: UserInfo
 * Package: servlet
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/28 21:39
 * @Version 1.0
 */
@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (session == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        // 把 user 转换成 json 格式返回
        resp.setContentType("application/json; charset=utf8");
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
