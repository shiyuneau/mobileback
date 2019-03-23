package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.SchoolEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface SchoolService  {
    /**
     * 获取所有得大学及大学得 专业信息
     */
    List<SchoolEntity> schoolList();

    /**
     * 根据 schoolGuid 获取 schol 的 介绍信息
     * @return
     */
    SchoolEntity schoolDetail(String schoolGuid);
}

