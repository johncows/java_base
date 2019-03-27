package com.kk;


import com.google.gson.Gson;
import com.kk.dto.User;

import org.junit.Test;

import java.io.IOException;

public class TestDemo {

    @Test
    public void  fun() throws IOException {
        User user = new User();
        user.setName("哇哦");
        user.setSex("男");
        user.setId(15);
        user.setAge(15);

        Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println("s = " + s);


    }


}
