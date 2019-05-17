package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.AccessLink;
import com.sy.mobileback.common.accessdb.AccessDBOperateUtils;
import com.sy.mobileback.common.reflect.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-05-09 12:13
 */
@Repository
public class AccessLinkDao {
    @Autowired
    private Connection accessConn;

    public List<AccessLink> selectAllLinks(int type) {
        List<AccessLink> linkList = new ArrayList<>();
        try {
            String sql = "select * from Link where L_Lidro = ?";
            List<Object> paramList = new ArrayList<>();
            paramList.add(type);
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                AccessLink link = new AccessLink();
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(link, entry.getKey(), entry.getValue());
                }
                linkList.add(link);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }
}
