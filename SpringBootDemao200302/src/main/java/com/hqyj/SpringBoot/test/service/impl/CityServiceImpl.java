package com.hqyj.SpringBoot.test.service.impl;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBoot.test.dao.CityDao;
import com.hqyj.SpringBoot.test.entity.City;
import com.hqyj.SpringBoot.test.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
//		return cityDao.getCitiesByCountryId(countryId);
		return Optional.ofNullable(cityDao.getCitiesByCountryId2(countryId))
				.orElse(Collections.emptyList());
	}

	@Override
	public City getCityByName(String cityName, String localCityName) {
		return cityDao.getCityByName(cityName, localCityName);
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<City>(Optional.ofNullable(cityDao.getCitiesByCountryId2(countryId))
					.orElse(Collections.emptyList()));
		
	}

	
}
