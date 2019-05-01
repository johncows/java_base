package com.kk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("toLogin")
    public String homePage() {
        return "home";
    }


}
