package com.kk.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kk.Exception.MyException;
import com.kk.dto.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class MyController {


    /**
     * 发送get请求 利用正则对请求进行校验
     * 返回全视图 将所有的数据由json写回
     */
    @JsonView(User.UserDetailView.class)
    @GetMapping(value = "{id:\\d+}")
    @ApiOperation(value = "获取信息")
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {
        User user = new User();
        user.setName("哇哦");
        user.setSex("男");
        user.setId(Integer.parseInt(id));
        user.setAge(15);
        return user;
    }


    /**
     * post添加请求
     * 针对post接受参数 进行校验
     * 1. 普通校验  @NotEmpty 非空校验 利用message返回报错信息
     * 2. 自定义校验 @MyConstraint 默认返回false
     */
    @JsonView(User.UserDetailView.class)
    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return user;
    }


    @GetMapping("error")
    public User throwException() {
        throw new MyException("一个运行时的异常错误");
    }


}
