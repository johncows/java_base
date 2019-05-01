package com.kk.controller;

import com.kk.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController1 {

    @RequestMapping("/hh")
    public String fun1(Model model){
        User user = new User();
        user.setName("wang");
        user.setPassword("123");
        model.addAttribute("user",user);
        return "hehe";
    }

}
