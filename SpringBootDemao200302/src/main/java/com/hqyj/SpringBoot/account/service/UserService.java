package com.hqyj.SpringBoot.account.service;

import com.hqyj.SpringBoot.account.entity.User;
import com.hqyj.SpringBoot.common.vo.Result;

public interface UserService {
   
    Result<User> insertUser(User user);
	
	User getUserByUserName(String userName);
}
