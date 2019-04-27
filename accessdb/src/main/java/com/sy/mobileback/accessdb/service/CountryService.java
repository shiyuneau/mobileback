package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.CountryEntity;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-27 10:44
 */
public interface CountryService {
    /**
     * 获取所有得国家id和名称
     * @return
     */
    List<CountryEntity> allCountryList();
}
