package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDAO;
import model.User;
import model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AuthorInfoServlet
 * Package: servlet
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/28 22:34
 * @Version 1.0
 */
@WebServlet("/authorInfo")
public class AuthorInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请求中缺少 blogId！");
            return;
        }
        // 在 blog 表中查询对应的 Blog 对象
        BlogDAO blogDAO = new BlogDAO();
        Blog blog = blogDAO.getBlog(Integer.parseInt(blogId));
        if (blog == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("blogId 未找到！");
            return;
        }
        // 根据 blog 对象中的 userId 来从 user 中查找作者
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserInfoById(blog.getUserId());
        if (user == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("userId 未找到！");
            return;
        }
        // 返回浏览器
        user.setPassword("");// 防止泄露密码
        String respJson = objectMapper.writeValueAsString(user);
        resp.setContentType("application/json");
        resp.getWriter().write(respJson);
    }
}
