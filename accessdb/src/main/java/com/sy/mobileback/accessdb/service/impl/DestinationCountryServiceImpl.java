package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.DestinationcountryEntity;
import com.sy.mobileback.accessdb.mapper.DestinationcountryDao;
import com.sy.mobileback.accessdb.service.DestinationCountryService;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-22 19:37
 */
@Service
public class DestinationCountryServiceImpl implements DestinationCountryService {

    @Autowired
    private DestinationcountryDao destinationcountryDao;

    @Override
    public JsonResult destinationCountryList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = destinationcountryDao.destinationcountryCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<DestinationcountryEntity> list = destinationcountryDao.destinationcountryList(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }
}
