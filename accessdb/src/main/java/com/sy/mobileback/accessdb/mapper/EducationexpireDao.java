package com.sy.mobileback.accessdb.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sy.mobileback.accessdb.domain.EducationexpireEntity;

import java.util.List;

/**
 * 教育经历表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public interface EducationexpireDao {
    void educationexpireBatchInsert(List<EducationexpireEntity> list);
}
