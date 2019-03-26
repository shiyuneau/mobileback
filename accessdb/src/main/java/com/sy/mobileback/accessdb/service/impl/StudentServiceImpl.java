package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.mapper.StudentDao;
import com.sy.mobileback.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sy.mobileback.accessdb.service.StudentService;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public String userLogin(String username, String password) {

        String guid = studentDao.usernamePasswordMatch(username,password);

        return guid;
    }

    @Override
    public String userExist(String username) {
        return studentDao.userHasRegistry(username);
    }

    @Override
    public void newUserInsert(StudentEntity entity) {
        studentDao.newUserInsert(entity);
    }

}
