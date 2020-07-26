package com.kk.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
}
