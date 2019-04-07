package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;

import java.util.List;

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

    /**
     * 奖学金申请取消 根据applyrecordid取消申请
     * @param userId
     * @param applyrecordid
     * @return
     */
    boolean applyCancel(String userId, String applyrecordid);

    /**
     * 奖学金申请列表  根据用户id展示申请列表
     * @param userId
     * @return
     */
    List<ScholarshipapplicationEntity> scholarcshipApplyList(String userId);

}
