package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.StudentEntity;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 19:09:22
 */
public interface StudentDao {
    String userHasRegistry(String username);

    String usernamePasswordMatch(@Param("username") String username , @Param("password") String password);

    void newUserInsert(StudentEntity entity);

    String usernameGet(String userId);

    boolean updateUser(Map<String,Object> person);

    String usernameExists(String username);

    boolean passwordreset(@Param("email")String email , @Param("newPass")String newPass , @Param("updateTime") Timestamp updateTime);
}
