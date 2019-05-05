package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.AnalysisEntity;
import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 12:41:19
 */
public interface StudyabroadapplicationDao {
    void studyabroadapplicationBatchInsert(List<StudyabroadapplicationEntity> list);

    /**
     * 用户申请表插入
     * @param entity
     */
    void studyabroadapplicationInsert(StudyabroadapplicationEntity entity);

    /**
     * 用户取消申请
     * @return
     */
    boolean applyCancel(Map<String,Object> map);

    /**
     * 根据用户ID查询申请表列表
     * @param userid
     * @return
     */
    List<StudyabroadapplicationEntity> applyList(String userid);
    /**
     * 审核留学申请数据列表  根据学生id  查询审核成功列表
     * @return
     */
    List<StudyabroadapplicationEntity> applyApplyedList(Map<String,Object> map);

    /**
     * 留学申请审核
     * @param map
     * @return
     */
    boolean applyCheck(Map<String, Object> map);

    /**
     * 获取所有高校的申请单的状态
     * @param managerGUID
     * @return
     */
    List<Integer> allStatusByGUID(String managerGUID);

    /**
     * 返回留学生申请的总个数
     * @return
     */
    Integer studyabroadApplyCount();

    List<StudyabroadapplicationEntity> studyabroadApplyListByPage(Map<String,Integer> map);

    /**
     * 根据学生ID返回申请单得个数
     * @param userid
     * @return
     */
    Integer applyCountByStudentGUID(String userid);

    /**
     * 按国籍获取申请单得数量
     * @return
     */
    List<AnalysisEntity> countByNationality();

    /**
     * 按国籍获取申请单得数量
     * @return
     */
    List<AnalysisEntity> countBySchool();

    /**
     * 按国籍获取申请单得数量
     * @return
     */
    List<AnalysisEntity> countByProfession();

    /**
     * 留学申请审批成功的个数
     * @return
     */
    Integer studyabroadApplySuccessCount();

    /**
     * 按照 年份，返回所有审批成功的信息
     */
    List<StudyabroadapplicationEntity> studyOfferByYear(String managerGUID);
}
