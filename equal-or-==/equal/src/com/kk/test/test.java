package com.kk.test;

import com.kk.domain.User;

public class test {
	public static void main(String[] args) {
		User user1 = new User("jack", 18);
		User user2 = new User("rose", 22);
		User user3 = user1;
		User user4 = new User("jack", 18);
		
		
		System.out.println(user1==user3);  //true
		System.out.println(user1.equals(user2));//false
		System.out.println(user3==user4);//false
		System.out.println(user4.equals(user3));//true
		
	}
}
