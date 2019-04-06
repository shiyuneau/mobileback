package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;

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
    boolean studyabroadApply(String userid , StudyabroadapplicationEntity entity);
}
