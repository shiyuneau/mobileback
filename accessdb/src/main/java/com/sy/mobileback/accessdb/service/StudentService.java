package com.sy.mobileback.accessdb.service;


import com.sy.mobileback.accessdb.domain.StudentEntity;

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

}

