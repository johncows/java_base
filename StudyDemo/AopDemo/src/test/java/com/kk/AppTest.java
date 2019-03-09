package com.kk;

import static org.junit.Assert.assertTrue;

import com.kk.Advice.extend.ProductExtend;
import com.kk.Advice.extend.SecondHandSell;
import com.kk.Pojo.People;
import com.kk.Pojo.Product;
import com.kk.Pojo.Student;
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
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = com.kk.ConcertConfig.class  )
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    @Qualifier("student")
    private Object student;

    @Test
    public void shouldAnswerWithTrue()
    {
        SecondHandSell productExtend = (SecondHandSell)student;
        productExtend.productSell();
        People student1 = (People) student;
        student1.speak();


    }
}
