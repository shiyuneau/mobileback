package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.FamilyinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 学生家庭成员表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public interface FamilyinfoDao {
    void familyinfoBatchInsert(List<FamilyinfoEntity> list);
}
