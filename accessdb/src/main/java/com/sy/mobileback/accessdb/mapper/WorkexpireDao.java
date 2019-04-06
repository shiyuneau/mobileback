package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.WorkexpireEntity;

import java.util.List;

/**
 * 工作经历表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public interface WorkexpireDao {
    void workexpireBatchInsert(List<WorkexpireEntity> list);

    List<WorkexpireEntity> workExpireList(String studyabroadGUID);
}
