package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.mapper.StudentDao;
import com.sy.mobileback.common.utils.DateUtils;
import com.sy.mobileback.common.utils.EmailUtils;
import com.sy.mobileback.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sy.mobileback.accessdb.service.StudentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Transactional
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmailUtils emailEntity;

    @Override
    public Map<String,String> userLogin(String username, String password) {

        Map<String,String> resultMap = studentDao.usernamePasswordMatch(username, password);

        return resultMap;
    }

    @Override
    public String userExist(String email) {
        List<String> guidList = studentDao.userHasRegistry(email);
        if (null!=guidList && guidList.size() > 0) {
            return "-1";
        }
        return null;
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
    @Transactional
    @Override
    public boolean passwordreset(String email) {
        try {
            String newPass = getRandomPassword(8);
            String md5Pass = MD5Util.getMD5(newPass);
            Timestamp updateTime = DateUtils.getDBTime();
            boolean updateFlag = studentDao.passwordreset(email, md5Pass, updateTime);
            if (updateFlag) {
                // 发送邮件
                emailEntity.passwordSendEmail(email, newPass);
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
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
