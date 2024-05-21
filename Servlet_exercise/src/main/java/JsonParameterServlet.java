import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: JsonParameterServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/21 23:32
 * @Version 1.0
 */
@WebServlet("/json")
public class JsonParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // json 转 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = objectMapper.readValue(req.getInputStream(), Request.class);
        System.out.println("username=" + request.username);
        System.out.println("password=" + request.password);

        Response response = new Response();
        response.ok = true;

        // 字符串 转 json
        String respJson = objectMapper.writeValueAsString(response);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(respJson);
    }
}

class Request {
    public String username;
    public String password;
}

class Response {
    public boolean ok;
}