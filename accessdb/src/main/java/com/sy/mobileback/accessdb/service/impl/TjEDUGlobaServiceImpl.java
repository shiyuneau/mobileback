package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.Comstye;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.mapper.NewsDao;
import com.sy.mobileback.accessdb.mapper.TjEDUGlobalDao;
import com.sy.mobileback.accessdb.service.TjEDUGlobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-05-09 12:31
 */
@Service
public class TjEDUGlobaServiceImpl implements TjEDUGlobaService {

    @Autowired
    TjEDUGlobalDao tjEDUGlobalDao;

    @Autowired
    NewsDao newsDao;

    @Override
    public List<Comstye> bslxList() {
        return tjEDUGlobalDao.bslxList();
    }

    @Override
    public List<NewsPage> selectBslcListByPage(int pageNum, String id) {
        return newsDao.selectBslcListByPage(pageNum,id);
    }

    @Override
    public NewsContent selectNewsById(String id) {
        return newsDao.selectById(id);
    }
}
