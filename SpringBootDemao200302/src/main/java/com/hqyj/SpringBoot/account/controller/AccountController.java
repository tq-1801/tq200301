package com.hqyj.SpringBoot.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@RequestMapping("/login")
	public String loginPage() {
		return "indexSimple";
	}
}
