package com.hqyj.SpringBoot.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
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
	@RequestMapping("/cities/{countryID}")
	
	public List<City> getCitiesByCountryId(@PathVariable int countryID) {
		return cityService.getCitiesByCountryId(countryID);
	}
	/**
	 * 127.0.0.1/api/city?cityName=Shanghai&localCityName=1111 ---- get
	 */
	@RequestMapping("/city")
	public City getCityByName(@RequestParam String cityName, @RequestParam String localCityName) {
		return cityService.getCityByName(cityName, localCityName);
	}
	
	/**
	 * 127.0.0.1/api/cities?currentPage=1&pageSize=5&countryId=522
	 */
	@RequestMapping("/cities")
	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage, 
			@RequestParam int pageSize, @RequestParam int countryId) {
		return cityService.getCitiesByPage(currentPage, pageSize, countryId);
	}
	
}
