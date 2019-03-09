package com.kk.vue.Controller;

import com.kk.vue.Pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController1 {


    @ResponseBody
    @RequestMapping("getStudentInfo")
    public Student fun1(){
        Student student = new Student();
        student.setName("jack");
        student.setAge(42);
        return student;
    }


}
