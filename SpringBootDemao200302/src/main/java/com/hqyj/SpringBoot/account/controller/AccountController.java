package com.hqyj.SpringBoot.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	/**
	 * 127.0.0.1/account/login
	 * @return
	 */

	@RequestMapping("/login")
	public String loginPage() {
		return "indexSimple";
	}
	/**
	 * 127.0.0.1/account/register
	 * @return
	 */
	
	@RequestMapping("/register")
	public String registerPag() {
		return "indexSimple";
	}
	
	/**
	 * http://127.0.0.1/account/shoppingLogin
	 */
	@RequestMapping("/shoppingLogin")
	public String shoppingLoginPage() {
		return "shoppingIndexSimple";
	}

	/**
	 * http://127.0.0.1/account/shoppingRegister
	 */
	@RequestMapping("/shoppingRegister")
	public String shoppingRegister() {
		return "shoppingIndexSimple";
	}
	
	/**
	 * http://127.0.0.1/account/users
	 * @return
	 */
	@RequestMapping("/users")
	public String usersPage() {
		return "index";
	}
	
	/**
	 * http://127.0.0.1/account/roles
	 */
	@RequestMapping("/roles")
	public String rolesPage() {
		return "index";
	}

	/**
	 * http://127.0.0.1/account/resources
	 */
	@RequestMapping("/resources")
	public String resourcesPage() {
		return "index";
	}
	
	/**
	 * http://127.0.0.1/account/profile
	 */
	@RequestMapping("/profile")
	public String profilePage() {
		return "index";
}
}