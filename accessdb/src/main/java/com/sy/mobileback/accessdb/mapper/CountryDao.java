package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.CountryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-27 10:36:31
 */
public interface CountryDao {
    void countryBatchInsert(List<CountryEntity> list);
    boolean countryUpdate(CountryEntity entity);
    List<CountryEntity> countryList();

    List<CountryEntity> listAllCountry();
}
