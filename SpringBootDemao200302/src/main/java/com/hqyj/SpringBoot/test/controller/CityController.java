package com.hqyj.SpringBoot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.SpringBoot.test.entity.City;
import com.hqyj.SpringBoot.test.service.CityService;
/**
 * 
 * 127.0.0.1/api/cities/522  ----get请求
 *
 */
@RestController
@RequestMapping("/api")

public class CityController {
	@Autowired
	private CityService cityService;
	@RequestMapping("/cities{countryID}")
	
	public List<City> getCitiesByCountryId(@PathVariable int countryID) {
		return cityService.getCitiesByCountryId(countryID);
	}
}
