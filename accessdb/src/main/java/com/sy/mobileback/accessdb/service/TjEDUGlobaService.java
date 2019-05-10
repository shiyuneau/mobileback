package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.Comstye;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-05-09 12:31
 */
public interface TjEDUGlobaService {

    /**
     * 所有办事流程的 列表
     */
    public List<Comstye> bslxList();

    /**
     * 根据ID 返回办事流程子菜单的 信息列表
     * @param pageNum
     * @param id
     * @return
     */
    List<NewsPage> selectBslcListByPage(int pageNum, String id);

    /**
     * 根据 文章id搜索 具体信息
     * @param id
     * @return
     */
    NewsContent selectNewsById(String id);
}
