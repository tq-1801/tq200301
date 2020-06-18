package com.hqyj.SpringBoot.config.shiro;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

@Configuration
public class ShiroConfig {
	
	@Autowired
	private MyRealm myRealm;
	
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myRealm);
		return securityManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setLoginUrl("/account/login");
		shiroFilterFactoryBean.setSuccessUrl("/common/dashboard");
		return shiroFilterFactoryBean;
	}

}
