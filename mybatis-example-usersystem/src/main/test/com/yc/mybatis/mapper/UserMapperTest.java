package com.yc.mybatis.mapper;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.yc.mybatis.entity.User;
import com.yc.mybatis.util.MyBatisUtil;

public class UserMapperTest {
	private UserMapper userMapper02;
	private UserMapper userMapper;
	private SqlSession session;
	private SqlSession session02;
	@Before
	public void setUp() throws Exception {
		session =  MyBatisUtil.getSession();
		session02 =  MyBatisUtil.getSession();
		userMapper =session.getMapper(UserMapper.class);
		userMapper02 = session02.getMapper(UserMapper.class);
	}

	@Test //一级缓存  也称session级缓存
	public void testGetUserById() {
		User user = userMapper.getUserById(10236);
		System.out.println("第一次取"+user);
		System.out.println("====================");
		user = userMapper02.getUserById(10236);
		System.out.println("第二次取"+user);
	}
	
	@Test //一级缓存  也称session级缓存
	public void testGetUserById02() {
		long start = System.currentTimeMillis();
		User user = userMapper.getUserById(10236);
		System.out.println("第一次取"+user);
		session.clearCache();
		System.out.println("====================");
		user = userMapper.getUserById(10236);
		System.out.println("第二次取"+user);
		long end  = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	@Test //一级缓存  也称session级缓存
	public void testGetUserById03() {
		long start = System.currentTimeMillis();
		User user = userMapper.getUserById(10236);
		System.out.println("第一次取"+user);
		//session.clearCache();
		user = userMapper.getUserById(10237);
		user.setName("小华");
		userMapper.updateUser(user);
		System.out.println("第二次取"+user);
		System.out.println("====================");
		user = userMapper.getUserById(10236);
		System.out.println("第三次取"+user);
		long end  = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	@Test 
	public void testGetUserById04() {
		long start = System.currentTimeMillis();
		User user = userMapper.getUserById(10236);
		System.out.println("第一次取"+user);
		//session.clearCache();
		session.commit();
		System.out.println("====================");
		user = userMapper02.getUserById(10236);
		System.out.println("第二次取"+user);
		long end  = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	@Test 
	public void testGetUserById05() {
		long start = System.currentTimeMillis();
		User user01 = userMapper.getUserById(10236);
		System.out.println("第一次取"+user01);
		session.commit();
		User user02 = userMapper.getUserById(10237);
		user02.setName("小华");
		userMapper.updateUser(user02);
		System.out.println("第二次取"+user02);//默认情况 insert,update,delete会清除缓存
		System.out.println("====================");
		User user03 = userMapper.getUserById(10236);
		System.out.println("第三次取"+user03);
		long end  = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
