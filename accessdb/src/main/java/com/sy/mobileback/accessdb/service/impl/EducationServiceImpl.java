package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.EducationEntity;
import com.sy.mobileback.accessdb.mapper.EducationDao;
import com.sy.mobileback.accessdb.service.EducationService;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-28 13:40
 */
@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationDao educationDao;

    @Override
    public JsonResult educationList() {
        JsonResult result = JsonResult.ok();
        try {
            List<EducationEntity> list = educationDao.educationList();
            result.put("rows",list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台查询错误");
        }
        return result;
    }
}
