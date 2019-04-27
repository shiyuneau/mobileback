package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sy.mobileback.accessdb.mapper.AlumniDao;
import com.sy.mobileback.accessdb.domain.AlumniEntity;
import com.sy.mobileback.accessdb.service.AlumniService;


@Service("alumniService")
public class AlumniServiceImpl implements AlumniService {

    @Autowired
    private AlumniDao alumniDao;

    @Override
    public JsonResult alumniSearchByName(String username) {
        JsonResult result = null;
        try {
            List<AlumniEntity> list = alumniDao.alumniSearchByName(username);
            result = JsonResult.ok();
            result.put("rows",list);
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonResult.error("查询后台错误");
        }
        return result;
    }

    @Override
    public Integer alumniCount(String userid) {
        return alumniDao.aluminCount(userid);
    }

    /**
     * 分页获取校友列表
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public JsonResult alumniList(Integer pageSize, Integer pageNum , String userid) {
        try {
            int total = alumniDao.aluminCount(userid);
            Map<String ,Object> map = new HashMap<>();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            map.putAll(pageMap);
            map.put("userid",userid);
            List<AlumniEntity> list = alumniDao.alumniList(map);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error();
        }
    }
}
