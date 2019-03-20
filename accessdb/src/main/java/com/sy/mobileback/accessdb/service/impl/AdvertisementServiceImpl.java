package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.mapper.AdvertisementDao;
import com.sy.mobileback.accessdb.domain.AdvertisementEntity;
import com.sy.mobileback.accessdb.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    @Override
    public List<AdvertisementEntity> advertisementList() {
        return advertisementDao.advertisemengEntityList();
    }
}
