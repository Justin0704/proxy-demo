package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.proxy.bean.User;

public class UserServiceInterceptor implements InvocationHandler {

	private final Logger logger = LoggerFactory.getLogger(UserServiceInterceptor.class);
	
	private Object realObject;
	
	
	public UserServiceInterceptor(Object realObject){
		this.realObject = realObject;
	}
	
	
	public Object getRealObject() {
		return realObject;
	}

	public void setRealObject(Object realObject) {
		this.realObject = realObject;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(args != null && args.length > 0 && args[0] instanceof User){
			User user = (User)args[0];
			if(user.getName().trim().length() < 1){
				throw new RuntimeException("用户姓名长度不能小于1个字符");
			}
		}
		Object ret = method.invoke(realObject, args);
		logger.info("插入输入据成功");
		return ret;
	}

}
