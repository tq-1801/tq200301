package com.hqyj.SpringBoot.account.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.SpringBoot.account.dao.UserDao;
import com.hqyj.SpringBoot.account.entity.User;
import com.hqyj.SpringBoot.account.service.UserService;
import com.hqyj.SpringBoot.common.vo.Result;
import com.hqyj.SpringBoot.common.vo.Result.ResultStatus;
import com.hqyj.SpringBoot.utils.MD5Util;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public Result<User> insertUser(User user) {
		User userTemp = getUserByUserName(user.getUserName());
		if (userTemp != null) {
			return new Result<User>(ResultStatus.FAILD.status, "User name is repeat.");
		}
		
		user.setCreateDate(new Date());
		user.setPassword(MD5Util.getMD5(user.getPassword()));
		
		userDao.insertUser(user);
		return new Result<User>(ResultStatus.SUCCESS.status, "Insert success.", user);
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	@Override
	public Result<User> login(User user) {
		User userTemp = userDao.getUserByUserName(user.getUserName());
		if (userTemp == null || !userTemp.getPassword().equals(MD5Util.getMD5(user.getPassword()))) {
			return new Result<User>(ResultStatus.FAILD.status, "User name or password error.");
		}

		return new Result<User>(ResultStatus.SUCCESS.status, "Login success.", userTemp);
	}


}
