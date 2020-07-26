package com.kk.jdbctmplate;

import com.kk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplateDemo {


    @Autowired
    private JdbcOperations jdbcOperations;


    public void insertUser(User user) {
        String sql = "insert into user values(?,?,?,?)";
        jdbcOperations.update(sql, user.getId(), user.getName(), user.getAge(), user.getBirthday());
    }


    public List<User> queryUser(Integer id) {
        String sql = "select * from user where id = ?";
        List<User> users = jdbcOperations.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setBirthday(resultSet.getDate(4));
                return user;
            }
        });
        return users;
    }
}
