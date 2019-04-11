package com.kk;

import java.util.Objects;

public class Person {
    private  String name;

    @Override
    public boolean equals(Object o) {
        System.out.println("进行equal比较");
        System.out.println((Person)o);
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        System.out.println("进行哈希运算");
//        return Objects.hash(getName());
        return  123;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
