package com.hqyj.size.modules.size.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.size.modules.size.entity.City;
import com.hqyj.size.modules.size.service.CityService;


@RestController
@RequestMapping("/api")
public class CityController {

	@Autowired
	private CityService cityService;

	/**
	 * 127.0.0.1:8761/api/cities/522
	 */
	@RequestMapping("/cities/{countryId}")
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		return cityService.getCitiesByCountryId(countryId);
	}
	}
	
