package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
