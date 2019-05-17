package com.sy.mobileback.accessdb.service;

import com.baomidou.mybatisplus.service.IService;
import com.sy.mobileback.accessdb.domain.AccessLink;
import com.sy.mobileback.accessdb.domain.LinkEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-27 20:57:56
 */
public interface LinkService{

    /**
     * 获取 天津各高校连接
     * @return
     */
    List<LinkEntity> links();

    /**
     * 返回所有access数据库中的 天津各高校链接
     * @return
     */
    List<AccessLink> accessLinks(int type);

}

