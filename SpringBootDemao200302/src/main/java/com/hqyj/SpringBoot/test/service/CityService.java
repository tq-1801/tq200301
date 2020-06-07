package com.hqyj.SpringBoot.test.service;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBoot.test.entity.City;

public interface CityService {
	
	List<City>getCitiesByCountryId(int countryID);
	
	City getCityByName(String cityName, String localCityName);
	
PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId);
	
}
