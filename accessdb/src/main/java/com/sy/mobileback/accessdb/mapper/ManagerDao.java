package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ManagerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 22:54:38
 */
public interface ManagerDao {
    void managerBatchInsert(List<ManagerEntity> list);

    String usernamePasswordMatch(@Param("username")String username , @Param("password")String password);
}
