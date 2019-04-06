package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.mapper.ManagerDao;
import com.sy.mobileback.accessdb.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String userLogin(String username, String password) {
        String guid = managerDao.usernamePasswordMatch(username, password);

        return guid;
    }
}
