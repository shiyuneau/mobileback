package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.AlumniEntity;
import com.sy.mobileback.common.utils.JsonResult;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface AlumniService  {
    /**
     * 根据 username 搜索校友得信息
     * @param username
     * @return
     */
    JsonResult alumniSearchByName(String username);

    Integer alumniCount(String userid);

    JsonResult alumniList(Integer pageSize , Integer pageNum  , String userid);
}

