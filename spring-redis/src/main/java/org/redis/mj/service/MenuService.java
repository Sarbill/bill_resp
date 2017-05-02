package org.redis.mj.service;


import org.redis.mj.dao.CityDao;
import org.redis.mj.entity.City;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by hx on 2017/2/4.
 */
@Service
public class MenuService {

    public static final Logger logger= LoggerFactory.getLogger(MenuService.class);

    @Autowired
    public CityDao dao;

    @Autowired
    public CacheManager cacheManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCity(City city){

        dao.insertCity(city);
    }



    @Cacheable(value = "queryCity",key = "#citycode")
    public List<City> queryCity(String citycode){
        City city=new City();
        city.setCitycode(citycode);
        List<City> citys=dao.queryCity(city);
        logger.info("--------"+citys.get(0).getCityname());
        return citys;
    }

    @CacheEvict(value ="queryCity",key = "#city.citycode")
    public Map<String,Object> updateCity(City city){
        Map<String,Object> res=new HashMap<String,Object>();
        city.setProvincecode(String.valueOf(Math.random()));

        int i=dao.updateCity(city);
        logger.info("update city:{}",city.getCitycode());
        if(i>0){
            res.put("success",true);
            res.put("msg","成功");
            return res;
        }else{
            res.put("success",false);
            res.put("msg","更新失败");
            return res;
        }
    }
}
