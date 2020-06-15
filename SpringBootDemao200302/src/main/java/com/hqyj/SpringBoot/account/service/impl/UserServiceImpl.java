package com.hqyj.SpringBoot.account.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBoot.account.dao.UserDao;
import com.hqyj.SpringBoot.account.dao.UserRoleDao;
import com.hqyj.SpringBoot.account.entity.Role;
import com.hqyj.SpringBoot.account.entity.User;
import com.hqyj.SpringBoot.account.service.UserService;
import com.hqyj.SpringBoot.common.vo.Result;
import com.hqyj.SpringBoot.common.vo.Result.ResultStatus;
import com.hqyj.SpringBoot.common.vo.SearchVo;
import com.hqyj.SpringBoot.utils.MD5Util;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
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
		userRoleDao.deleteRolesByUserId(user.getUserId());
		List<Role> roles = user.getRoles();
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				userRoleDao.insertUserRole(user.getUserId(), role.getRoleId());
			}
		}
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


	@Override
	public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
		searchVo.initSearchVo();
		PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
		return new PageInfo<User>(
				Optional.ofNullable(userDao.getUsersBySearchVo(searchVo))
				.orElse(Collections.emptyList()));
	
	}
	
	@Override
	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	@Transactional
	public Result<User> updateUser(User user) {
		User userTemp = getUserByUserName(user.getUserName());
		if (userTemp != null) {
			return new Result<User>(ResultStatus.FAILD.status, "User name is repeat.");
		}

		userDao.updateUser(user);

		userRoleDao.deleteRolesByUserId(user.getUserId());
		List<Role> roles = user.getRoles();
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				userRoleDao.insertUserRole(user.getUserId(), role.getRoleId());
			}
		}

		return new Result<User>(ResultStatus.SUCCESS.status, "Update success.", user);
	}

	@Override
	public Result<Object> deleteUser(int userId) {
		userDao.deleteUser(userId);
		userRoleDao.deleteRolesByUserId(userId);
		return new Result<Object>(ResultStatus.SUCCESS.status, "Delete success.");
	}
}
