package com.sy.mobileback.common.page;

import com.sy.mobileback.common.utils.JsonResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-15 18:59
 */
public class PageUtils<T>  {

    public static Map<String,Integer> pageCreate(int pageNum , int pageSize) {
        int pageMin = (pageNum-1) * pageSize;
        int pageMax = pageNum * pageSize;
        Map<String , Integer> pageMap = new HashMap<>();
        pageMap.put("pageMin",pageMin);
        pageMap.put("pageMax",pageMax);
        return pageMap;
    }

    public static<T> JsonResult resultCreate(List<T> list , Integer total) {
        JsonResult result = JsonResult.ok();
        result.put("rows",list);
        result.put("total",total);
        return result;
    }
}
