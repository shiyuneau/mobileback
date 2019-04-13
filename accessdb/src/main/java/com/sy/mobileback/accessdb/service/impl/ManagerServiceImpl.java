package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.ManagerEntity;
import com.sy.mobileback.accessdb.mapper.ManagerDao;
import com.sy.mobileback.accessdb.service.ManagerService;
import com.sy.mobileback.common.utils.DateUtils;
import com.sy.mobileback.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-07 0:04
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public String userExist(String email) {
        List<String> guidList = managerDao.userHasRegistry(email);
        if (null!=guidList && guidList.size() > 0) {
            return "-1";
        }
        return null;
    }

    @Override
    public Map<String,String> userLogin(String username, String password) {
        Map<String,String> result = managerDao.usernamePasswordMatch(username, password);

        return result;
    }

    @Override
    public void newUserInsert(ManagerEntity entity) {
        managerDao.newUserInsert(entity);
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
        return managerDao.updateUser(person);
    }

    @Override
    public String usernameGet(String userId) {
        return managerDao.usernameGet(userId);
    }
}
