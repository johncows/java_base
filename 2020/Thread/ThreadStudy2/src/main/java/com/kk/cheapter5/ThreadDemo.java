package com.kk.cheapter5;

import java.util.Arrays;

public class ThreadDemo {
    public static void main(String[] args) {
        new SimpleThreadObServer().concurrentQuery(Arrays.asList("1","2","3","4"));
    }
}
