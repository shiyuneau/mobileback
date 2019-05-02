package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 11:18
 */
public interface FileService {
    /**
     * 根据申请类型上传文件
     * @param filePath
     * @param originalFileName
     * @param userID
     * @param type
     * @return
     */
    String fileUpload(String filePath , String originalFileName , String userID ,Integer type);


    /**
     *
     * @param prefix
     * @param file
     * @param userID
     * @param type
     * @return
     */
    JsonResult fileUploadOriginName(String prefix , MultipartFile file, String userID, Integer type);

    /**
     * 根据fileid 查找 文件的 存储地址
     * @param fileid
     * @return
     */
    String getFilePath(String fileid);
}
