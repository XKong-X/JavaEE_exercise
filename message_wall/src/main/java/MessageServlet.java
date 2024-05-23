import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    //private List<Message> messageList = new ArrayList<>();// 使用数据库后就不需要这行代码了

    // 1. 创建数据源
    private DataSource dataSource = new MysqlDataSource();
    @Override
    public void init() throws ServletException {
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/message_wall?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("0000");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将读到的数据保存到服务器中
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        System.out.println("收到的 message: " + message);
        // 直接存到内存中方便测试
        //messageList.add(message);// 使用数据库后就不需要这行代码了
        // 插入数据库
        try {
            save(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 返回一个响应
        resp.setStatus(200);
//        resp.setContentType("application/json");
//        resp.getWriter().write("{ ok: true }");
        resp.getWriter().write("ok");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json; charset=utf-8");
        List<Message> messageList = null;
        try {
            messageList = load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String respJson = objectMapper.writeValueAsString(messageList);
        resp.getWriter().write(respJson);
    }

    private void save(Message message) throws SQLException {
        // 2. 建立连接(1. 在上面 init 那)
        Connection connection = dataSource.getConnection();

        // 3. 构造数据库
        String sql = "insert into message values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, message.from);
        statement.setString(2, message.to);
        statement.setString(3, message.message);

        // 4. 执行 SQL
        statement.executeUpdate();

        // 5. 回收资源
        statement.close();
        connection.close();
    }

    private List<Message> load() throws SQLException {
        // 2. 建立连接(1. 在上面 init 那)
        Connection connection = dataSource.getConnection();

        // 3. 构造数据库
        String sql = "select * from message";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4. 执行 SQL
        ResultSet resultSet = statement.executeQuery();

        // 5. 遍历结果集合
        List<Message> messageList = new ArrayList<>();
        while (resultSet.next()) {
            Message message = new Message();
            message.from = resultSet.getString("from");
            message.to = resultSet.getString("to");
            message.message = resultSet.getString("message");
            messageList.add(message);
        }

        // 6. 回收资源
        resultSet.close();
        statement.close();
        connection.close();

        // 7. 返回 messageList
        return messageList;
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