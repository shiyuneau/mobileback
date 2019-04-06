package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.UploadfileEntity;
import com.sy.mobileback.accessdb.mapper.UploadfileDao;
import com.sy.mobileback.accessdb.service.FileService;
import com.sy.mobileback.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:19
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private UploadfileDao uploadfileDao;


    @Override
    public String fileUpload(String filePath, String originalFileName, String userID,Integer type) {
        String uuid = UUID.randomUUID().toString();
        UploadfileEntity entity = new UploadfileEntity();
        entity.setGuid(uuid);
        entity.setFilepath(filePath);
        entity.setOriginfilename(originalFileName);
        entity.setStudentguid(userID);
        Timestamp timestamp = DateUtils.getDBTime();
        entity.setInserttime(timestamp);
        entity.setType(type);
        boolean uploadFlag = uploadfileDao.fileUpload(entity);;
        if (uploadFlag) {
            return uuid;
        }
        return null;
    }

    @Override
    public String getFilePath(String fileid) {
        return uploadfileDao.getFilePath(fileid);
    }
}
