package com.yc.mybatis.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yc.mybatis.util.MyBatisUtil;

public class MyBatisUtilTest {

	@Test
	public void testGetSession() {
		assertNotNull(MyBatisUtil.getSession().getConnection());
	}

	@Test
	public void testGetAutoCommitSession() {
		assertNotNull(MyBatisUtil.getAutoCommitSession().getConnection());
	}

}
