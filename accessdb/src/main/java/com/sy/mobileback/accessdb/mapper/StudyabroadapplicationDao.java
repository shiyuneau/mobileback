package com.sy.mobileback.accessdb.mapper;

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
}
