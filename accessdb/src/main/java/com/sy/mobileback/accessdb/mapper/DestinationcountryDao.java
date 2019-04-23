package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.DestinationcountryEntity;
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
public interface DestinationcountryDao {
    void destinationcountryBatchInsert(List<DestinationcountryEntity> list);
    boolean destinationcountryUpdate(DestinationcountryEntity entity);
    List<DestinationcountryEntity> destinationcountryList(Map<String,Integer> map);
    Integer destinationcountryCount();
}
