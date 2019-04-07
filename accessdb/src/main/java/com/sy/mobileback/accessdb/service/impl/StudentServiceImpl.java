package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.mapper.StudentDao;
import com.sy.mobileback.common.utils.DateUtils;
import com.sy.mobileback.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sy.mobileback.accessdb.service.StudentService;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Random;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public String userLogin(String username, String password) {

        String guid = studentDao.usernamePasswordMatch(username, password);

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

    @Override
    public String usernameGet(String userId) {
        return studentDao.usernameGet(userId);
    }

    @Override
    public boolean updateUser(String userId, Map<String, Object> person) {
        person.put("userID", userId);
        if (person.containsKey("password")) {
            String password = (String) person.get("password");
            password = MD5Util.getMD5(password);
            person.put("password", password);
        }
        Timestamp updateTime = DateUtils.getDBTime();
        person.put("updateTime", updateTime);
        return studentDao.updateUser(person);
    }

    @Override
    public boolean usernameExists(String username) {
        String guid = studentDao.usernameExists(username);
        if (null == guid) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 假设 邮箱是唯一的，根据邮箱去更新密码
     * @param email
     * @return
     */
    @Override
    public String passwordreset(String email) {
        String newPass = getRandomPassword(8);
        String md5Pass = MD5Util.getMD5(newPass);
        Timestamp updateTime = DateUtils.getDBTime();
        boolean updateFlag = studentDao.passwordreset(email,md5Pass,updateTime);
        if (updateFlag) {
            // 发送邮件
            return newPass;
        }
        return null;
    }

    public static String getRandomPassword(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String str = String.valueOf(random.nextInt(10));
            val.append(str);
        }
        return val.toString();
    }

}
