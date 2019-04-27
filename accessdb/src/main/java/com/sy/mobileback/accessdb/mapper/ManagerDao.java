package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ManagerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 22:54:38
 */
public interface ManagerDao {
    void newUserInsert(ManagerEntity entity);

    void managerBatchInsert(List<ManagerEntity> list);

    List<String> userHasRegistry(String email);

    boolean updateUser(Map<String,Object> person);

    Map<String,Object> usernamePasswordMatch(@Param("username")String username , @Param("password")String password);

    /**
     * 根据 userId 获取用户名称
     * @param userId
     * @return
     */
    String usernameGet(String userId);
}
