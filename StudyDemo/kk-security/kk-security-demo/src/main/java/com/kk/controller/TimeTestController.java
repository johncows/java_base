package com.kk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("time")
public class TimeTestController {


    @GetMapping
    public void fun1(int age){
        System.out.println("曾经胆小 不敢做不该做的事 现在胆子小 不敢做该做的事");
    }

}
