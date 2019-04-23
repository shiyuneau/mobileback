package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.domain.PlanapplyEntity;
import com.sy.mobileback.accessdb.mapper.PlanapplyDao;
import com.sy.mobileback.accessdb.service.PlanapplyService;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-21 21:31
 */
@Service
public class PlanapplyServiceImpl implements PlanapplyService {

    @Autowired
    private PlanapplyDao planapplyDao;

    @Override
    public JsonResult palanapplyList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = planapplyDao.planapplyCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<PlanapplyEntity> list = planapplyDao.planapplyList(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }
}
