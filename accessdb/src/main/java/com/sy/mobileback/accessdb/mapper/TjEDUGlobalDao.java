package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.Comstye;
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
 * @Description 天津教育国际交流
 * @create 2019-05-09 12:27
 */
@Repository
public class TjEDUGlobalDao {

    @Autowired
    private Connection accessConn;


    /**
     * 办事流程 子菜单 list
     */
    public List<Comstye> bslxList() {
        List<Comstye> linkList = new ArrayList<>();
        try {
            String sql = "select * from Comstye where Com_Fid = 106";
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                Comstye comstey = new Comstye();
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(comstey, entry.getKey(), entry.getValue());
                }
                linkList.add(comstey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }

}
