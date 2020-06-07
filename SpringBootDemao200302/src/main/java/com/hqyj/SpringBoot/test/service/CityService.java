package com.hqyj.SpringBoot.test.service;

import java.util.List;

import com.hqyj.SpringBoot.test.entity.City;

public interface CityService {
	List<City>getCitiesByCountryId(int countryID);
}
