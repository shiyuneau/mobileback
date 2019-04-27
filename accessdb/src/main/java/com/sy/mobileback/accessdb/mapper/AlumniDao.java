package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.AlumniEntity;
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
public interface AlumniDao {
    void alumniBatchInsert(List<AlumniEntity> list);
    boolean alumniUpdate(AlumniEntity entity);
    List<AlumniEntity> alumniList(Map<String,Object> map);

    List<AlumniEntity> alumniSearchByName(String username);

    /**
     * 学校得总数
     * @return
     */
    Integer aluminCount(String userid);
}
