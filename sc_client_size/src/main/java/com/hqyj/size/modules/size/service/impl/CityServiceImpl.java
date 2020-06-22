package com.hqyj.size.modules.size.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.size.modules.size.dao.CityDao;
import com.hqyj.size.modules.size.entity.City;
import com.hqyj.size.modules.size.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		return Optional.ofNullable(cityDao.getCitiesByCountryId(countryId))
				.orElse(Collections.emptyList());
	}

}
