package com.sy.mobileback.accessdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.mobileback.accessdb.mapper.LinkDao;
import com.sy.mobileback.accessdb.domain.LinkEntity;
import com.sy.mobileback.accessdb.service.LinkService;

import java.util.List;


@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    public List<LinkEntity> links() {
        return linkDao.links();
    }
}
