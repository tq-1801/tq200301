package com.hqyj.SpringBoot.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.SpringBoot.test.entity.City;
import com.hqyj.SpringBoot.test.entity.Country;
import com.hqyj.SpringBoot.test.service.CityService;
import com.hqyj.SpringBoot.test.service.CountryService;
import com.hqyj.SpringBoot.test.vo.ApplicationTest;

@Controller
@RequestMapping("/test")
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
	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;
	/**
	 * 127.0.0.1/test/index
	 */
	
	/**
	 * 127.0.0.1/test/index
	 */
	@RequestMapping("/index")
	public String indexPage(ModelMap modelmap) {
		int countryId = 522;
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		Country country = countryService.getCountryByCountryId(countryId);
		
		modelmap.addAttribute("thymeleafTitle", "scdscsadcsacd");
		modelmap.addAttribute("checked", true);
		modelmap.addAttribute("currentNumber", 99);
		modelmap.addAttribute("changeType", "checkbox");
		modelmap.addAttribute("baiduUrl", "/test/log");
		modelmap.addAttribute("city", cities.get(0));
		modelmap.addAttribute("shopLogo", 
				"http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelmap.addAttribute("country", country);
		modelmap.addAttribute("cities", cities);
		modelmap.addAttribute("updateCityUri", "/api/city");
		modelmap.addAttribute("template", "test/index");
		
		return "index";
	}
	
	
	/**
	 * 127.0.0.1/test/log
	 */
	@RequestMapping("/log")
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
 * 127.0.0.1/config
 */
	@RequestMapping("/config")
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
 * 127.0.0.1/test/desc
 */
	@RequestMapping("/desc")
	@ResponseBody
	public String testDesc() {
		return "This is test module desc.112233";
	}
}

