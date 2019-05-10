package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.UploadfileEntity;
import com.sy.mobileback.accessdb.mapper.UploadfileDao;
import com.sy.mobileback.accessdb.service.FileService;
import com.sy.mobileback.common.utils.DateUtils;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:19
 */
@Service
public class FileServiceImpl implements FileService {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);


    @Autowired
    private UploadfileDao uploadfileDao;


    @Override
    public String fileUpload(String filePath, String originalFileName, String userID, Integer type) {
        String uuid = UUID.randomUUID().toString();
        UploadfileEntity entity = new UploadfileEntity();
        entity.setGuid(uuid);
        entity.setFilepath(filePath);
        entity.setOriginfilename(originalFileName);
        entity.setStudentguid(userID);
        Timestamp timestamp = DateUtils.getDBTime();
        entity.setInserttime(timestamp);
        entity.setType(type);
        boolean uploadFlag = uploadfileDao.fileUpload(entity);
        ;
        if (uploadFlag) {
            return uuid;
        }
        return null;
    }

    @Override
    public JsonResult fileUploadOriginName(String prefix, MultipartFile file, String userID, Integer type) {
        JsonResult result = JsonResult.ok();

        try {
            String filename = file.getOriginalFilename();
            String filePath = prefix + "/" + filename;
            if (new File(filePath).exists()) {
                logger.info("filename文件已存在，删除文件");
                new File(filePath).delete();
            }
            String uuid = UUID.randomUUID().toString();
            UploadfileEntity entity = new UploadfileEntity();
            entity.setGuid(uuid);
            entity.setFilepath(filePath);
            entity.setOriginfilename(filename);
            entity.setStudentguid(userID);
            Timestamp timestamp = DateUtils.getDBTime();
            entity.setInserttime(timestamp);
            entity.setType(type);
            boolean uploadFlag = uploadfileDao.fileUpload(entity);
            if (uploadFlag) {
                File dest = new File(filePath);
                file.transferTo(dest);
                logger.info("上传成功");
                result = JsonResult.ok();
                result.put("fileid", uuid);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            result = JsonResult.error("上传错误");
        } catch (IOException e) {
            e.printStackTrace();
            result = JsonResult.error("上传错误");
        }
        return result;
    }

    @Override
    public String getFilePath(String fileid) {
        String filepath = uploadfileDao.getFilePath(fileid);
        int index = filepath.lastIndexOf("/");
        String name = filepath.substring(index + 1, filepath.length());
        name = "http://lxtj.tmecglobal.org.cn/API/" + name;
        return name;
    }
}
