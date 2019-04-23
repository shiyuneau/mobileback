package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.PlanapplyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-21 21:13:02
 */
public interface PlanapplyDao {
    void planapplyBatchInsert(List<PlanapplyEntity> list);
    boolean planapplyUpdate(PlanapplyEntity entity);
    List<PlanapplyEntity> planapplyList(Map<String,Integer> map);
    Integer planapplyCount();
}
