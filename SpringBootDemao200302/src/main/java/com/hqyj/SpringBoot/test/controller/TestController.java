package com.hqyj.SpringBoot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.SpringBoot.test.vo.ApplicationTest;

@Controller
public class TestController {
	@Value("${server.port}")
	private int port;
	@Value("${com.thornBirth.name}")
	private String name;
	@Value("${com.thornBirth.age}")
	private int age;
	@Value("${com.thornBirth.desc}")
	private String desc;
	@Value("${com.thornBirth.random}")
	private String random;
	
	@Autowired
	private ApplicationTest ApplicationTest;
/**
 * 127.0.0.1:8085/test/config
 */
	@RequestMapping("/test/config")
	@ResponseBody
	public String configInfo() {
		StringBuffer sb=new StringBuffer();
		sb
		.append(port).append("----")
		.append(name).append("----")
		.append(age).append("----")
		.append(desc).append("----")
		.append(random).append("----").append("<br>");
		
		sb
		.append(ApplicationTest.getName1()).append("----")
		.append(ApplicationTest.getAge1()).append("----")
		.append(ApplicationTest.getDesc1()).append("----")
		.append(ApplicationTest.getRandom1()).append("----").append("<br>");
		return sb.toString();
	    
	}
/**
 * 127.0.0.1:8086/test/desc
 */
	@RequestMapping("/test/dest")
	@ResponseBody
	public String testDesc() {
		return "This is test module desc.112233";
	}
}

