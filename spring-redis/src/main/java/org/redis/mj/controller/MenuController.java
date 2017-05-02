package org.redis.mj.controller;

import org.redis.mj.dao.CityDao;
import org.redis.mj.entity.City;
import org.redis.mj.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hx on 2017/2/3.
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController {

    public static final Logger logger= LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService service;

    @RequestMapping(value = "/tohome")
    public String toHome(){

        return "menu";
    }

    @RequestMapping(value = "/insertCity.do")
    public void insertCity(City city){

        service.insertCity(city);
    }

    @RequestMapping(value = "/queryCity.do")
    @ResponseBody
    public Map<String,Object> queryCity(String citycode){
        logger.info("controllerLog:{}",MenuController.class);

        List<City> citys=service.queryCity(citycode);
        Map<String,Object> res=new HashMap<String,Object>();
        if(null!=citys&&citys.size()>0){
            res.put("row",citys);
            res.put("success",true);
        }else {
            res.put("success",false);
        }

        return res;
    }

    @RequestMapping(value = "/updateCity.do")
    @ResponseBody
    public Map<String,Object> updateCity(String citycode){
        logger.info("updatecity:{}",MenuController.class);
        City city=new City();
        city.setCitycode(citycode);
        Map<String,Object> res=service.updateCity(city);


        return res;
    }


}
