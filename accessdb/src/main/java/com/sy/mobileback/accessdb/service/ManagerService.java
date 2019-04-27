package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ManagerEntity;

import java.util.Map;

/**
 * @author shiyu
 * @Description manager管理者的服务
 * @create 2019-04-07 0:03
 */

public interface ManagerService {

    /**
     * 判断用户是否已经注册
     * @param email
     * @return
     */
    String userExist(String email);

    Map<String,Object> userLogin(String username, String password);

    /**
     * 插入新的manager对象
     * @param entity
     */
    void newUserInsert(ManagerEntity entity);

    /**
     * 根据 userID 和 person map 对 指定的userId 进行属性的更新
     * @param userId
     * @param person
     * @return
     */
    boolean updateUser(String userId , Map<String,Object> person);
    /**
     * 根据 userId 获取用户名称
     * @param userId
     * @return
     */
    String usernameGet(String userId);
}
