package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ProfessionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 22:54:38
 */
public interface ProfessionDao {
    void professionBatchInsert(List<ProfessionEntity> list);
}
