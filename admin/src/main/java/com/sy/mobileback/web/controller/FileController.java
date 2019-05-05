package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.service.FileService;
import com.sy.mobileback.common.annotation.Log;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.web.core.config.FileConfig;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 0:20
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    /**
     * 文件上传 ，内容都再 form_data里面
     *
     * @param file
     * @param type    申请表类型 ， 奖学金还是留学
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/upload")
    public Map<String, String> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("type") Integer type, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("code", "1");
        if (file.isEmpty()) {
            map.put("code", "-1");
            map.put("msg", "文件为空，请选择文件");
            return map;
        }
        if (null == type) {
            type = 0;
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userid = (String) claims.get("userId");
//        String userid = "bb47e847-85ed-4778-bba4-7b49ca915469";
        String path = FileConfig.getProfile();
        String originalFileName = file.getOriginalFilename();
        String fileName = userid + "_" + originalFileName;
        path = path + fileName;
        String authToken = (String) request.getAttribute("token");
        String fileID = fileService.fileUpload(path, originalFileName, userid, type);
        System.out.println(path);
        File dest = new File(path);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            map.put("fileid", fileID);
            return map;
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }

        return null;
    }


    /**
     * 文件下载 根据文件ID
     *
     * @param fileid
     * @return
     */
    @Log(title = "文件下载")
    @JwtIgnore
    @PostMapping("/download")
    @ResponseBody
    public Map<String, String> fileDownload(@RequestParam("fileid") String fileid) {
        Map<String, String> result = new HashMap<>();
        String filePath = fileService.getFilePath(fileid);
        if (StringUtils.isNotEmpty(filePath)) {
            result.put("filepath", filePath);
        }
        return result;
    }

    /**
     * 文件二进制流返回
     */
    @JwtIgnore
    @PostMapping("/filepreview")
    @ResponseBody
    public ResponseEntity<InputStreamResource> filePreview(@RequestParam("fileid") String fileid, HttpServletRequest request, HttpServletResponse response) {
        try {
            String filePath = fileService.getFilePath(fileid);
            FileSystemResource file = new FileSystemResource(filePath);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(file.getInputStream()));
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("dfsId:{}下载文件失败，cause:{}",fileid,e);
        }finally {
        }
        return org.springframework.http.ResponseEntity.status(1).build();
    }
}
