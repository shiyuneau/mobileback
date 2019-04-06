package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.SchoolEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sy.mobileback.accessdb.domain.SchoolSearchResultEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface SchoolDao {
	List<SchoolEntity> schoolList();
	SchoolEntity schoolDetail(String schoolGuid);

	/**
	 * 根据指定条件搜索学校
	 * @param map
	 * @return
	 */
	List<SchoolSearchResultEntity> schoolSearch(Map<String,Object> map);
}
