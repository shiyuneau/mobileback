package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.EducationexpireEntity;
import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.domain.WorkexpireEntity;
import com.sy.mobileback.accessdb.mapper.EducationexpireDao;
import com.sy.mobileback.accessdb.mapper.ScholarshipapplicationDao;
import com.sy.mobileback.accessdb.mapper.WorkexpireDao;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @auther ShiYan.Shi
 * @email shaun_ssy@163.com
 * @create 2019/4/5   23:52
 */
@Service("scholarshipApplicationService")
public class ScholarshipApplicationServiceImpl implements ScholarshipApplicationService {
    @Autowired
    private ScholarshipapplicationDao scholarshipapplicationDao;
    @Autowired
    private EducationexpireDao educationexpireDao;
    @Autowired
    private WorkexpireDao workexpireDao;

    @Override
    public String studyabroadApply(String userId, ScholarshipapplicationEntity entity) {
        String applyUUID = UUID.randomUUID().toString();
        entity.setGuid(applyUUID);
        entity.setStudentguid(userId);
        Timestamp dbTime = DateUtils.getDBTime();
        entity.setCreatedtime(dbTime);
        entity.setUpdatedtime(dbTime);
        List<EducationexpireEntity> educationList = entity.getEducationList();
        educationList.forEach(list ->{
            String eduID = UUID.randomUUID().toString();
            list.setStudentguid(userId);
            list.setScholarshipguid(applyUUID);
            list.setGuid(eduID);
        });
        List<WorkexpireEntity> workList = entity.getWorkList();
        workList.forEach(List ->{
            String workID = UUID.randomUUID().toString();
            List.setGuid(workID);
            List.setScholarshipguid(applyUUID);
            List.setStudentguid(userId);
        });
        try {
            scholarshipapplicationDao.scholarshipapplicationInsert(entity);
            educationexpireDao.educationexpireBatchInsert(educationList);
            workexpireDao.workexpireBatchInsert(workList);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return applyUUID;
    }

}
