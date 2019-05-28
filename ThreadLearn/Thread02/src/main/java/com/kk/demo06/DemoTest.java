package com.kk.demo06;

/**
 * @author KK
 * @create 2019-05-24 21:16
 *
 **/
public class DemoTest {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User user1 = new User("sanheren", "sanhe", gate);
        User user2 = new User("tianjingren", "tianjing", gate);
        User user3 = new User("baodingren", "baoding", gate);

        user1.start();
        user2.start();
        user3.start();

    }
}
