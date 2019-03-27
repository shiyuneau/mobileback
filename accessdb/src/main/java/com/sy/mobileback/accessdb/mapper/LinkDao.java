package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.LinkEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-27 20:57:56
 */
public interface LinkDao {
    List<LinkEntity> links();
}
