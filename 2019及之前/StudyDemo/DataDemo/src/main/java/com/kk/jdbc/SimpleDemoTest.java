package com.kk.jdbc;

import com.kk.pojo.User;

import java.security.PublicKey;
import java.sql.*;
import java.util.Date;


/*
 * JDBC操作数据库的步骤:
 * 1.注册驱动
 * 		告知JVM使用的是哪一个数据库的驱动
 * 2.获得连接
 * 		使用JDBC中的类,完成对mysql数据库的连接(TCP协议)
 * 3.获得语句执行平台
 * 		通过连接对象获取对SQL语句的执行者对象
 * 4.执行sql语句
 * 		使用执行者对象,向数据库执行SQL语句
 * 		获取数据库的执行后的结果
 * 5.处理结果
 * 6.释放资源
 * 		调用一堆close
 */

//原生sql代码
public class SimpleDemoTest {


    public static Connection getConnection() throws Exception {

//        告知jvm 需要调用哪个驱动类 会抛出ClassNotfoundException
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/springData?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
//        获取连接对象 抛出SqlException
        Connection connection = DriverManager.getConnection(url, username, password);
//        返回对象
        return connection;
    }


    /**
     * 插入操作
     *
     * @param user
     * @param connection
     */
    public static void insertUser(User user, Connection connection) throws SQLException {

        String sql = "insert into user values(?,?,?,?)";
//        创建sql执行语句 抛出SqlException
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        参数写入
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setDate(4, null);
//        执行语句
        boolean execute = preparedStatement.execute();
    }


    /**
     * 删除操作
     *
     * @param connection
     * @param id
     * @throws SQLException
     */
    public static User queryUser(Connection connection, Integer id) throws SQLException {
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = new User();
        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
        }
        return user;
    }


}
