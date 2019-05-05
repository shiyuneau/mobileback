package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.common.utils.JsonResult;

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
     *
     * @param userId
     * @param entity
     * @return
     */
    String studyabroadApply(String userId, ScholarshipapplicationEntity entity);

    /**
     * 奖学金申请取消 根据applyrecordid取消申请
     *
     * @param userId
     * @param applyrecordid
     * @return
     */
    boolean applyCancel(String userId, String applyrecordid);

    /**
     * 奖学金申请列表  根据用户id展示申请列表
     *
     * @param userId
     * @return
     */
    List<ScholarshipapplicationEntity> scholarcshipApplyList(String userId);

    /**
     * 奖学金审核
     *
     * @param userFlag
     * @param applyrecordid
     * @return
     */
    boolean applyCheck(int userFlag, String applyrecordid,int applyResultType , String applyAdvice);

    /**
     * 奖学金申请列表 需要传递 schoolGUID 参数
     * @param managerGUID
     * @return
     */
    List<ScholarshipapplicationEntity> applyApplyedList(String managerGUID ,int userFlag);

    /**
     * 根据 新的 留学金申请单信息，更新新的申请，并把 status 更改为 1
     * @param entity
     * @param userid
     * @return
     */
    boolean sholarshipApplyUpdate(ScholarshipapplicationEntity entity , String userid);

    /**
     * 根据userFlag判断用户是高校还是教委，分别统计对应的奖学金的申请情况
     * @param userFlag
     * @param userId
     * @return
     */
    JsonResult scholarshipApplyCount(int userFlag , String userId);

    /**
     * 根据学生ID返回申请单得个数
     * @param userid
     * @return
     */
    Integer applyCountByStudentGUID(String userid);

    /**
     * 按照国籍和学校列出比例
     * @param type
     * @return
     */
    JsonResult scholarshipAnalysis(Integer type);

}
