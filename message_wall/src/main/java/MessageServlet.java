import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MessageServlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/22 21:08
 * @Version 1.0
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将读到的数据保存到服务器中
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        System.out.println("收到的 message: " + message);
        // 直接存到内存中方便测试
        messageList.add(message);
        // 返回一个响应
        resp.setStatus(200);
//        resp.setContentType("application/json");
//        resp.getWriter().write("{ ok: true }");
        resp.getWriter().write("ok");

    }
}

// 记得重写 toString 不然打印的就是地址
class Message {
    public String from;
    public String to;
    public String message;

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}