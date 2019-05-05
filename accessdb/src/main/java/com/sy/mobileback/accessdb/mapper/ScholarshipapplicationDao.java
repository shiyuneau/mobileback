package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.AnalysisEntity;
import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 12:41:19
 */
@Repository
public interface ScholarshipapplicationDao {
    void scholarshipapplicationBatchInsert(List<ScholarshipapplicationEntity> list);

    void scholarshipapplicationInsert(ScholarshipapplicationEntity entity);

    boolean applyExecute(Map<String, Object> map);

    List<ScholarshipapplicationEntity> applyList(String userId);

    List<ScholarshipapplicationEntity> applyApplyedList(Map<String, Object> map);

    boolean applyCheck(Map<String, Object> map);

    boolean scholarshipapplicationUpdate(ScholarshipapplicationEntity entity);

    List<Integer> allStatusByGUID(Map<String, Object> map);

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
     * 奖学金申请审批成功的个数
     * @return
     */
    Integer scholarshipApplySuccessCount();
}
