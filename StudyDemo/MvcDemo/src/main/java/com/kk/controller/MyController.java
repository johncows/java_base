package com.kk.controller;

import com.kk.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
//类级别注解
//@RequestMapping(value = {"user","/"},method = RequestMethod.POST)

public class MyController {

    //  简单的例子 传来Get请求 该注解为方法级别
    @RequestMapping(value = "{page}", method = RequestMethod.GET)
    public String fun1(@PathVariable String page) {
        if (page.startsWith("login"))
            return "login";
        else
            return "register";
    }


    @RequestMapping(value = "login")
    public String fun2(User user) {
        System.out.println(user);
        return "redirect:index.jsp";
    }

    @RequestMapping(value = "register")
    public String fun3(User user, MultipartFile image) throws IOException {
        System.out.println(user);
//      将上传资源写入到本地
        image.transferTo(new File("D://" + image.getOriginalFilename()));
        return "success";
    }


    //    返回自定义异常类
    @RequestMapping(value = "error")
    public String fun4(User user) {
        throw new Exception2();
    }


    //    当出现Exception1异常时 执行以下处理!!!!
    @ExceptionHandler(Exception1.class)
    public String fun1() {
        System.out.println("类级别处理异常");
        return "error";
    }


}
