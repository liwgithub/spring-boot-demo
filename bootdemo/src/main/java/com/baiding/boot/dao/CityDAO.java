package com.baiding.boot.dao;

import com.baiding.boot.model.City;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/16.
 */
public interface CityDAO {
    /**
     *根据城市 ID，获取城市信息
     * @param id
     * @return
     */
    City selectCityById(Integer id);

    /**
     * 根据国家编号 得到城市
     * @param countryCode
     * @return
     */
    List<City> selectCityByCountry(String  countryCode);

    /**
     *获取城市信息列表
     * @return
     */
    List<City> findAllCIty();

    /**
     * 保存city
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 更新city
     * @param city
     * @return
     */
    Long updateCity(City city);

    /**
     * 删除city
     * @param id
     * @return
     */

    Long deleteCity(Integer id);
}
