package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;

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
}
