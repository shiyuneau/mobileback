package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.CollegeEntity;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface CollegeService  {
    List<CollegeEntity> collegeList();
    CollegeEntity collegeDetail(String collegeGuid);
}

