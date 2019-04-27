package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.CountryEntity;
import com.sy.mobileback.accessdb.service.CountryService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-27 10:47
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * 返回国家名称和ID对应得列表
     * @return
     */
    @JwtIgnore
    @GetMapping("/countrylist")
    @ResponseBody
    public List<CountryEntity> listAllCountry() {
        return countryService.allCountryList();
    }
}
