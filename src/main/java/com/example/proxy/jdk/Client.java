package com.example.proxy.jdk;

import java.lang.reflect.Proxy;

import com.example.proxy.bean.User;

public class Client {

	public static void main(String[] args) {
		
		User user = new User();
		user.setBirthday("2000-2-2");
		user.setAge(20);
		user.setName("张三");
		IUserService userService = new UserServiceImpl();
		
		//invocationHandler把真实对象包进去
		UserServiceInterceptor usi = new UserServiceInterceptor(userService);
		
		//生成动态代理的实例
		IUserService proxy = (IUserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), usi);
		
		//通过动态代理去生成一个用户
		proxy.addUser(user);
		System.out.println("-------");
		//System.out.println(proxy.hashCode());
		
		
	}
}
