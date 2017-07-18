package com.baiding.boot.service.impl;

import com.baiding.boot.dao.CityDAO;
import com.baiding.boot.model.City;
import com.baiding.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/16.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public City selectCityById(Integer id) {
        return cityDAO.selectCityById(id);
    }

    @Override
    public List<City> selectCityByCountry(String countryCode) {
        return cityDAO.selectCityByCountry(countryCode);
    }
}
