package com.hqyj.SpringBoot.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hqyj.SpringBoot.test.entity.City;

@Mapper
public interface CityDao {
  List<City>getCitiesByCountryId(int countryID);
}
