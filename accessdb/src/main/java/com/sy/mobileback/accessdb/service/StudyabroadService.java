package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;
import com.sy.mobileback.common.utils.JsonResult;

import java.util.List;

/**
 * @author shiyu
 * @Description 留学申请 service
 * @create 2019-04-06 14:26
 */
public interface StudyabroadService {
    /**
     * 留学申请表创建
     * @param userid
     * @param entity
     * @return
     */
    String studyabroadApply(String userid , StudyabroadapplicationEntity entity);

    /**
     * 根据applyid 删除 订单
     * @param applyid
     * @return
     */
    boolean applyCancel(String userid , String applyid);

    /**
     * 根据学生ID，　查询学生的　待审核的　申请列表
     * @param userid
     * @return
     */
    List<StudyabroadapplicationEntity> studentApplyList(String userid);

    /**
     * 审核留学申请  根据学生ID,申请ID 更改审核状态
     * @param userId
     * @param applyid
     * @return
     */
    boolean applyCheck(String userId, String applyid,int appResultType);

    /**
     * 审核留学申请数据列表  根据学校id  查询审核成功列表
     * @param managerGUID
     * @return
     */
    List<StudyabroadapplicationEntity> applyApplyedList(String managerGUID);

    /**
     * 对申请留学的申请单进行统计
     * @param userFlag
     * @return
     */
    JsonResult studyabroadApplyCount(int userFlag , String managerGUID);

    JsonResult studyabroadApplyListByPage(int pageNum  , int pageSize);

    /**
     * 根据学生id返回学生申请得申请单个数
     * @param userid
     * @return
     */
    Integer applyCountByStudentGUID(String userid);

    /**
     * 根据 type 的不同，分别 按 国籍、专业、学校统计学生数量
     * @param type
     * @return
     */
    JsonResult studyaboardAnalysis(Integer type);

    /**
     * 根据 学校的 不同，返回当年的该学校 成功审批的offer
     * @param managerGUID
     * @return
     */
    JsonResult studyOfferByYear(String managerGUID);
}
