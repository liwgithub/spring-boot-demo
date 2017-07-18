package com.baiding.boot.dao;

import com.baiding.boot.model.City;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/16.
 */
public interface CityDAO {

    City selectCityById(Integer id);

    List<City> selectCityByCountry(String  countryCode);
}
