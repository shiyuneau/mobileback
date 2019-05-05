package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.EducationEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-28 09:35:09
 */
public interface EducationDao {
    void educationBatchInsert(List<EducationEntity> list);
    boolean educationUpdate(EducationEntity entity);
    List<EducationEntity> educationList();

}
