package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BlogDAO
 * Package: model
 * Description:
 *
 * @Author 行空XKong
 * @Create 2024/5/25 23:04
 * @Version 1.0
 */
public class BlogDAO {
    // 提交博客操作
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 建立连接
            connection = DBUtil.getConnection();
            // 构造 sql
            String sql = "insert into blog values (null, ?, ?, now(), ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            // 执行
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    // 查询博客列表
    public List<Blog> getBlog() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));

                // 读到的是整个正文，需要做截断
                String content = resultSet.getString("content");
                if (content.length() > 100) {
                    content = content.substring(0, 100) + "...";
                }
                blog.setContent(content);

                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogList.add(blog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blogList;
    }

    // 根据 id 查询指定博客
    public Blog getBlog(int blogId) {
        return null;
    }

    // 根据博客 id 删除博客
    public void delete(int blogId) {

    }
}
