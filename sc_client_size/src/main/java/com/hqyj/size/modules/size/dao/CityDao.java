package com.hqyj.size.modules.size.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hqyj.size.modules.size.entity.City;



@Mapper
public interface CityDao {

	@Select("select * from m_city where country_id = #{countryId}")
	List<City>getCitiesByCountryId(int countryId);
}
