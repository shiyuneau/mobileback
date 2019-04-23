package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.PassportEntity;
import com.sy.mobileback.accessdb.mapper.PassportDao;
import com.sy.mobileback.accessdb.service.PassportService;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-22 19:50
 */
@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportDao passportDao;

    @Override
    public Integer passportSearchCount(String passportName) {
        return passportDao.passportSearchCount(passportName);
    }

    @Override
    public JsonResult passportSearch(Map<String, Object> map) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = passportDao.passportSearchCount(map.get("searchName").toString());
            Map<String, Integer> pageMap = PageUtils.pageCreate((Integer)(map.get("pageNum")), (Integer)(map.get("pageSize")));
            map.putAll(pageMap);
            map.remove("pageSize");
            map.remove("pageNum");
            List<PassportEntity> list = passportDao.passportList(map);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }
}
