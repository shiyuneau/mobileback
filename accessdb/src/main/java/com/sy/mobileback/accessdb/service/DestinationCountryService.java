package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.common.utils.JsonResult;


/**
 * @author shiyu
 * @Description
 * @create 2019-04-22 19:35
 */
public interface DestinationCountryService {
    JsonResult destinationCountryList(int pageNum , int pageSize);
}
