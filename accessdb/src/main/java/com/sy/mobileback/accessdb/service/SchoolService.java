package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.SchoolEntity;
import com.sy.mobileback.accessdb.domain.SchoolSearchResultEntity;
import com.sy.mobileback.common.utils.JsonResult;

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

    /**
     * 返货 所有的大学信息，只有 学校的ID 和名称
     * @return
     */
    List<SchoolEntity> schools();

    List<SchoolSearchResultEntity> schoolSearch(Map<String,Object> map);

    /**
     * 根据高校管理者id  返回学校id
     * @param userId
     * @return
     */
    List<String> schoolByManagerguid(String userId);

    /**
     * 根据 高校管理者返回学校的简介及其他信息
     * @param managerGUID
     * @return
     */
    JsonResult introductionByMangerGUID(String managerGUID);

    /**
     * 根据 高校管理者返回学院的简介及其他信息
     * @param managerGUID
     * @return
     */
    JsonResult collegeinfoByMangerGUID(String managerGUID);

    /**
     * 根据 高校管理者返回学院的简介及其他信息
     * @param managerGUID
     * @return
     */
    JsonResult professioninfoByMangerGUID(String managerGUID);

}

