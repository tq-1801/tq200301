package com.hqyj.SpringBoot.test.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.SpringBoot.test.dao.CityDao;
import com.hqyj.SpringBoot.test.entity.City;
import com.hqyj.SpringBoot.test.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
    private CityDao CityDao;
	@Override
	public List<City> getCitiesByCountryId(int countryID) {
		
	//return CityDao.getCitiesByCountryId(countryID);
	return Optional.ofNullable(CityDao.getCitiesByCountryId(countryID))
			.orElse(Collections.emptyList());
	}

}
