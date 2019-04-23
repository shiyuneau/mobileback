package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.common.utils.JsonResult;

import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-22 19:48
 */
public interface PassportService {
    Integer passportSearchCount(String passportName);

    JsonResult passportSearch(Map<String,Object> map);
}
