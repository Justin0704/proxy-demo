package com.example.proxy.cglig;

import org.springframework.cglib.proxy.Enhancer;

import com.example.proxy.bean.User;

public class Client {

	public static void main(String[] args) {
		
		User user = new User();
		user.setBirthday("2000-2-2");
		user.setAge(20);
		user.setName("james");
		
		Enhancer enhance = new Enhancer();
		enhance.setSuperclass(UserServiceImpl.class);
		enhance.setCallback(new UserServiceInterceptor());//方法增强
		
		UserServiceImpl user1 = (UserServiceImpl)enhance.create();
		user1.addUser(user);
	}
}
