package com.baiding.boot.service;

import com.baiding.boot.model.City;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/16.
 */
public interface CityService {

    City selectCityById(Integer id);

    List<City> selectCityByCountry(String  countryCode);
}
