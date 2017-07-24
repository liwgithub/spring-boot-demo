package com.baiding.boot.service;

import com.baiding.boot.model.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 * Created by BaiDing on 2017/7/16.
 */
public interface CityService {

    /**
     * 根据城市 ID,查询城市信息
     * @param id
     * @return
     */
    City selectCityById(Integer id);

    List<City> selectCityByCountry(String  countryCode);
    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long deleteCity(Integer id);
}
