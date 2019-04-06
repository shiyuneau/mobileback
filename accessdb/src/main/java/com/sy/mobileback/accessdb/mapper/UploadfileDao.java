package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.UploadfileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 11:15:11
 */
public interface UploadfileDao {
	boolean fileUpload(UploadfileEntity entity);
	String getFilePath(String fileid);
}
