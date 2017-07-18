package com.baiding.boot.controller;

import com.baiding.boot.model.City;
import com.baiding.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by BaiDing on 2017/7/16.
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/selectCityById")
    @ResponseBody
    public City selectCity(Integer id){
        return cityService.selectCityById(id);
    }

    @RequestMapping("/selectCityByCountry")
    @ResponseBody
    public List<City> selectCityByCountry(String code){
        return cityService.selectCityByCountry(code);
    }
}
