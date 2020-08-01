package com.example.proxy.cglig;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.example.proxy.bean.User;

public class UserServiceInterceptor implements MethodInterceptor{

	private static Logger logger = LoggerFactory.getLogger(UserServiceInterceptor.class);
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		if(args != null && args.length > 0 && args[0] instanceof User){
			User user = (User)args[0];
			if(user.getName().trim().length() < 1){
				throw new RuntimeException("用户名的长度不能小于1");
			}
		}
		Object ret = proxy.invokeSuper(obj, args);
		logger.info("操作数据库成功");
		return ret;
	}
	
}
