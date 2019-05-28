package com.kk.demo05;

import java.util.Arrays;

/**
 * @author KK
 * @create 2019-05-23 17:02
 **/
public class DemoTest {

    public static void main(String[] args) {
        new ThreadLifeCycleListener().concurrentQuery(Arrays.asList("1","2"));
    }

}
