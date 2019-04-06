package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 12:41:19
 */
public interface StudyabroadapplicationDao {
    void studyabroadapplicationBatchInsert(List<StudyabroadapplicationEntity> list);
    void studyabroadapplicationInsert(StudyabroadapplicationEntity entity);
}
