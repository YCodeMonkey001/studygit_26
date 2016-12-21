package com.yc.mybatis.mapper;

import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.User;

public interface UserMapper {

	User findUser(User user);
	
	PaginationBean<User> getUsersByPagination(PaginationBean<User> users);
	
	int updateUser(User user);
	
	User getUserById(int id);
}
