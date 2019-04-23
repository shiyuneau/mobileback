package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ResourceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-21 21:13:02
 */
public interface ResourceDao {
    void resourceBatchInsert(List<ResourceEntity> list);
    boolean resourceUpdate(ResourceEntity entity);
    List<ResourceEntity> resourceList();
}
