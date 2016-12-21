package com.yc.mybatis.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.User;
import com.yc.mybatis.service.UserService;
import com.yc.mybatis.service.impl.UserServiceImpl;

public class UserServiceImplTest {

	private UserService userService;
	
	@Before
	public void setUp(){
		userService = new UserServiceImpl();
	}
	@Test
	public void testLogin() {
		User user = new User();
		user.setId(10242);
		user.setName("nrtusx");
		boolean result = userService.login(user);
		assertEquals(true, result);
		
	}
	
	@Test
	public void testGetPartUsers() {
		
		PaginationBean<User> userBean = userService.listPartUsers(null, null);
		
		System.out.println(userBean);
		assertNotNull(userBean);
		
	}

}
