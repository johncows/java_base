package com.kk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestDemo {

    public static void main(String[] args) {
        Person person1 = new Person("aaa");
        Person person2 = new Person("bbb");
        Person person3 = new Person("ccc");
        HashMap<Person, String> map = new HashMap<>();
        map.put(person1, "王");
        map.put(person2, "周");
        map.put(person3, "宋");

        list(map);
    }

    public static void list(Map<Person, String> map) {

        Set<Map.Entry<Person, String>> entrySet = map.entrySet();

        for (Map.Entry<Person, String> pse : entrySet) {
            System.out.println(pse.getKey() + "----" + pse.getValue());
        }

    }


}
