package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.CollegeEntity;
import com.sy.mobileback.accessdb.mapper.CollegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.mobileback.accessdb.service.CollegeService;

import java.util.List;


@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public List<CollegeEntity> collegeList() {
        return collegeDao.collegeList();
    }

    @Override
    public CollegeEntity collegeDetail(String collegeGuid) {
        return collegeDao.collegeDetail(collegeGuid);
    }
}
