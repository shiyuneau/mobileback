package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.PassportEntity;
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
public interface PassportDao {
    void passportBatchInsert(List<PassportEntity> list);
    boolean passportUpdate(PassportEntity entity);
    List<PassportEntity> passportList(Map<String,Object> map);
    Integer passportSearchCount(String searchName);
}
