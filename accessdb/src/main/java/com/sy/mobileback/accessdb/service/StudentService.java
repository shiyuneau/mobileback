package com.sy.mobileback.accessdb.service;


import com.sy.mobileback.accessdb.domain.StudentEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 19:09:22
 */
public interface StudentService {
    /**
     * 根据用户名和密码去查询数据库中是否有此纪录
     * @param username
     * @param password
     * @return
     */
    String userLogin(String username ,String password);

    /**
     * 判断用户是否已经注册
     * @param username
     * @return
     */
    String userExist(String username);

    /**
     * 新学生插入
     * @param entity
     */
    void newUserInsert(StudentEntity entity);

    /**
     * 根据 userId 获取用户名称
     * @param userId
     * @return
     */
    String usernameGet(String userId);

    /**
     * 根据 userID 和 person map 对 指定的userId 进行属性的更新
     * @param userId
     * @param person
     * @return
     */
    boolean updateUser(String userId , Map<String,Object> person);

    /**
     * 判断当前的username在数据库中是否存在
     * @param username
     * @return
     */
    boolean usernameExists(String username);

    /**
     * 密码重置
     * @param email
     * @return
     */
    boolean passwordreset(String email);


}

