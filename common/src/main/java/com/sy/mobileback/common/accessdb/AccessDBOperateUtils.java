package com.sy.mobileback.common.accessdb;

import com.sy.mobileback.common.reflect.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:09
 */
@Component
public class AccessDBOperateUtils {



    @Autowired
    public static Connection accessConn;

    private static Logger logger = LoggerFactory.getLogger(AccessDBOperateUtils.class);

    /**
     * 增加、删除、改
     *
     * @param sql    sql
     * @param params 参数
     * @return 添加结果
     */
    public static boolean update(String sql, List<Object> params) throws SQLException {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = accessConn;//AccessConnectionUtils.getConn();
            assert conn != null;//直接抛异常
            ps = conn.prepareStatement(sql);
            int index = 1;
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, null);
        }
        return result > 0;
    }

    /**
     * 查询多条记录
     *
     * @param sql    sql
     * @param params 参数
     * @return 查询结果
     */
    public static List<Map<String, Object>> select(Connection conn ,String sql, List<Object> params) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        int index = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            assert conn != null;
            ps = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int col_len = metaData.getColumnCount();
            Map<String, Object> map = null;
            while (rs.next()) {
                map = new HashMap<>();
                for (int i = 0; i < col_len; i++) {
                    String cols_name = metaData.getColumnName(i + 1);
                    Object cols_value = rs.getObject(cols_name);
                    if (cols_value == null) {
                        cols_value = "";
                    }
                    map.put(cols_name, cols_value);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, rs);
        }
        return list;
    }

    /**
     * 通过反射机制查询多条记录
     *
     * @param sql    sql
     * @param params 参数
     * @param clazz  类
     * @return 查询结果
     */
    public static <T> List<T> select(String sql, List<Object> params,
                                     Class<T> clazz) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        int index = 1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = AccessConnectionUtils.getConn();
            assert conn != null;
            ps = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int cols_len = metaData.getColumnCount();
            T t;
            while (rs.next()) {
                //通过反射机制创建一个实例
                t = clazz.newInstance();
                for (int i = 0; i < cols_len; i++) {
                    String cols_name = metaData.getColumnName(i + 1);
                    Object cols_value = rs.getObject(cols_name);
                    if (cols_value == null) {
                        cols_value = "";
                    }
                    Field field = clazz.getDeclaredField(cols_name);//获取对象属性
                    field.setAccessible(true); //打开javabean的访问权限
                    field.set(t, cols_value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, rs);
        }
        return list;
    }

}