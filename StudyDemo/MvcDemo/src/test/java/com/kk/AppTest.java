package com.kk;

import static org.junit.Assert.assertTrue;


import com.kk.controller.MyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;

/**
 * Unit test for simple App.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = com.kk.ConcertConfig.class  )
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest
{

    @Test
    public void shouldAnswerWithTrue()
    {
//        MyController myController = new MyController();


        Person person = new Person();

//        System.out.println("person = " + person);
        person.sex = "男";
        person.setName("jack");


        System.out.println(person.toString());




    }
}
