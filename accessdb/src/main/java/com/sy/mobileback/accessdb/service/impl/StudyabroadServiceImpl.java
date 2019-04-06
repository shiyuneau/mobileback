package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.*;
import com.sy.mobileback.accessdb.mapper.EducationexpireDao;
import com.sy.mobileback.accessdb.mapper.FamilyinfoDao;
import com.sy.mobileback.accessdb.mapper.StudyabroadapplicationDao;
import com.sy.mobileback.accessdb.mapper.WorkexpireDao;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 14:29
 */

@Service
public class StudyabroadServiceImpl implements StudyabroadService {

    @Autowired
    private EducationexpireDao educationexpireDao;
    @Autowired
    private WorkexpireDao workexpireDao;
    @Autowired
    private FamilyinfoDao familyinfoDao;
    @Autowired
    private StudyabroadapplicationDao studyabroadapplicationDao;
    @Override
    public boolean studyabroadApply(String userid, StudyabroadapplicationEntity entity) {
        // 流程
        // 首先创建 申请表的 UUID  , 存入
        // 分别取出 educationList , workList , familyList  ， 分别创建 uuid，并把 申请的 uuid 和 学生ID 存入
        String applyUUID = UUID.randomUUID().toString();
        entity.setGuid(applyUUID);
        entity.setStudentguid(userid);
        Timestamp time = DateUtils.getDBTime();
        entity.setCreatedtime(time);
        entity.setUpdatedtime(time);

        List<EducationexpireEntity> educationList = entity.getEducationList();
        educationList.forEach(education -> {
            String eduID = UUID.randomUUID().toString();
            education.setStudentguid(userid);
            education.setStudyabroadguid(applyUUID);
            education.setGuid(eduID);
        });

        List<WorkexpireEntity> workList = entity.getWorkList();
        workList.forEach(work -> {
            String workID = UUID.randomUUID().toString();
            work.setStudentguid(userid);
            work.setStudyabroadguid(applyUUID);
            work.setGuid(workID);
        });

        List<FamilyinfoEntity> familyList = entity.getFamilyList();
        familyList.forEach(family -> {
            String familyID = UUID.randomUUID().toString();
            family.setStudentguid(userid);
            family.setStudyabroadguid(applyUUID);
            family.setGuid(familyID);
        });
        try {
            studyabroadapplicationDao.studyabroadapplicationInsert(entity);
            educationexpireDao.educationexpireBatchInsert(educationList);
            workexpireDao.workexpireBatchInsert(workList);
            familyinfoDao.familyinfoBatchInsert(familyList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
