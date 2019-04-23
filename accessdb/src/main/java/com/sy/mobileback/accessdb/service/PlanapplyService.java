package com.sy.mobileback.accessdb.service;

import com.baomidou.mybatisplus.service.IService;
import com.sy.mobileback.accessdb.domain.PlanapplyEntity;
import com.sy.mobileback.common.utils.JsonResult;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-21 21:13:02
 */
public interface PlanapplyService {
    JsonResult palanapplyList(int pageNum, int pageSize);

}

