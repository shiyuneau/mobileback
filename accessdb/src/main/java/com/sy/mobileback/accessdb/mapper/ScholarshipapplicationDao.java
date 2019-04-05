package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:09
 */
public interface ScholarshipapplicationDao {
    void scholarshipapplicationBatchInsert(List<ScholarshipapplicationEntity> list);
}
