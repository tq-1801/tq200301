package com.hqyj.SpringBoot.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGR = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test/log")
	@ResponseBody
	public String logTest() {
		//TRACE<DEBUG<INFO<WARN<ERROR
		LOGGR.trace("This is TRACE log");
		LOGGR.debug("This is DEBUG log");
		LOGGR.info("This is INFO log");
		LOGGR.warn("This is WARN log");
		LOGGR.error("This is ERROR log");
		return "This is log test.";
	}
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

