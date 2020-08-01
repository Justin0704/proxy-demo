package com.example.proxy.jdk;

import com.example.proxy.bean.User;

public class UserServiceImpl implements IUserService {

	@Override
	public void addUser(User user) {
		
		System.out.println("插入数据库成功：user.toString = " + user.toString());
	}

}
