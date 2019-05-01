package com.kk;

import com.kk.Pojo.Student;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;

public class ReflectionDemo {


    public void reflectionFun() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        student.setName("jack");
        student.setAge(15);
        Class<? extends Student> clazz = student.getClass();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "nick");
        String s = (String) field.get(student);
        System.out.println("s = " + s);
    }


    @Test
    public void serializableFun() throws IOException {

        Student student = new Student();
        student.setAge(15);
        student.setName("jim");

        File file = new File("D:\\fileSrc\\obj");
        file.createNewFile();
        OutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        objectOutputStream.close();


    }


}
