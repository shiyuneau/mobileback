package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.CountryEntity;
import com.sy.mobileback.accessdb.mapper.CountryDao;
import com.sy.mobileback.accessdb.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-27 10:46
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public List<CountryEntity> allCountryList() {
        return countryDao.listAllCountry();
    }
}
