package com.hqyj.SpringBoot.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.SpringBoot.account.entity.User;
import com.hqyj.SpringBoot.account.service.UserService;
import com.hqyj.SpringBoot.common.vo.Result;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 127.0.0.1/api/user ---- post
	 */
	@PostMapping(value = "/user", consumes = "application/json")
	public Result<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	@PostMapping(value = "/login", consumes = "application/json")
	public Result<User> login(@RequestBody User user) {
		return userService.login(user);
	}
}

