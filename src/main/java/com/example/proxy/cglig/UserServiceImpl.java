package com.example.proxy.cglig;

import com.example.proxy.bean.User;

public class UserServiceImpl {

	public void addUser(User user){
		System.out.println("用户数据插入成功：" + user.toString());
	}
}
