package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.CollegeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface CollegeDao {
	List<CollegeEntity> collegeList();

    CollegeEntity collegeDetail(String collegeGuid);

    List<CollegeEntity> collegeinfoByMangerGUID(String managerGUID);
}
