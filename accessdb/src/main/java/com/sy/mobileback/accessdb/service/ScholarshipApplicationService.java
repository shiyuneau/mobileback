package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;

/**
 * 奖学金
 *
 * @auther ShiYan.Shi
 * @create 2019/4/5   23:50
 */
public interface ScholarshipApplicationService {
    /**
     * 奖学金申请
     * @param userId
     * @param entity
     * @return
     */
    String studyabroadApply(String userId, ScholarshipapplicationEntity entity);
}
