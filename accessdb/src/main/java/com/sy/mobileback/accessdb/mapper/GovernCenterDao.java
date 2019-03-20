package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
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
 * @create 2019-03-19 19:03
 */
@Repository
public class GovernCenterDao {
    @Autowired
    private Connection accessConn;

    public List<GoverCenterEntity> goverCenterList() {
        List<GoverCenterEntity> entityList = new ArrayList<>();
        String sql = "select Com_Id , Com_Fid , Com_Stye from Comstye";
        try {
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            if (null != list && list.size() > 0) {
                for (Map<String, Object> mapInfo : list) {
                    GoverCenterEntity entity = new GoverCenterEntity();
                    for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                        ReflectUtils.invokeSetter(entity, entry.getKey(), entry.getValue());
                    }
                    entityList.add(entity);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
