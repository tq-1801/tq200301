package com.hqyj.size.modules.size.service;

import java.util.List;

import com.hqyj.size.modules.size.entity.City;



public interface CityService {

	List<City>getCitiesByCountryId(int countryId);
}
