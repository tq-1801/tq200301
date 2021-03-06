package com.hqyj.account.modules.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hqyj.account.modules.account.entity.User;

@Mapper
public interface UserDao {

	@Select("select * from user where user_id =#{userId}")
	User getUserByUserId(int userId);
}
