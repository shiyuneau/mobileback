package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.MessageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-21 21:13:02
 */
public interface MessageDao {
    void messageBatchInsert(List<MessageEntity> list);
    boolean messageUpdate(MessageEntity entity);
    List<MessageEntity> messageList();
}
