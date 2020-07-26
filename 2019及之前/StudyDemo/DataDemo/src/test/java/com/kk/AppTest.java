package com.kk;


import com.kk.config.RootContext;
import com.kk.jdbctmplate.JdbcTemplateDemo;
import com.kk.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootContext.class)
public class AppTest {

    @Autowired
    private JdbcTemplateDemo jdbcTemplateDemo;

    private User getUser() {
        User user = new User();
        user.setId(6);
        user.setName("小王");
        user.setAge(158);
        user.setBirthday(new Date());
        return user;
    }


    @Test
    public void shouldAnswerWithTrue() throws Exception {
        User user = getUser();
        jdbcTemplateDemo.insertUser(user);
    }
}
