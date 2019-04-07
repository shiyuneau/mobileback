package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.EducationexpireEntity;
import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.domain.WorkexpireEntity;
import com.sy.mobileback.accessdb.mapper.EducationexpireDao;
import com.sy.mobileback.accessdb.mapper.ScholarshipapplicationDao;
import com.sy.mobileback.accessdb.mapper.WorkexpireDao;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.common.enums.ApplicationStatusType;
import com.sy.mobileback.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String studyabroadApply(String userId, ScholarshipapplicationEntity entity) {
        String applyUUID = UUID.randomUUID().toString();
        entity.setGuid(applyUUID);
        entity.setStudentguid(userId);
        Timestamp dbTime = DateUtils.getDBTime();
        entity.setCreatedtime(dbTime);
        entity.setUpdatedtime(dbTime);
        List<EducationexpireEntity> educationList = entity.getEducationList();
        educationList.forEach(list -> {
            String eduID = UUID.randomUUID().toString();
            list.setStudentguid(userId);
            list.setScholarshipguid(applyUUID);
            list.setGuid(eduID);
        });
        List<WorkexpireEntity> workList = entity.getWorkList();
        workList.forEach(List -> {
            String workID = UUID.randomUUID().toString();
            List.setGuid(workID);
            List.setScholarshipguid(applyUUID);
            List.setStudentguid(userId);
        });
        try {
            scholarshipapplicationDao.scholarshipapplicationInsert(entity);
            educationexpireDao.educationexpireBatchInsert(educationList);
            workexpireDao.workexpireBatchInsert(workList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return applyUUID;
    }

    /**
     * 根据用户id和申请id 取消申请 更改申请单状态,1待审批，2审批成功，3审批失败，4用户取消当前审批',
     *
     * @param userId
     * @param applyrecordid
     * @return
     */
    @Override
    public boolean applyCancel(String userId, String applyrecordid) {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userId);
        map.put("applyrecordid", applyrecordid);
        map.put("status", ApplicationStatusType.UserCancelApply.getType());
        return scholarshipapplicationDao.applyExecute(map);
    }

    @Override
    public List<ScholarshipapplicationEntity> scholarcshipApplyList(String userId) {
        //查询用户id下所有申请表
        List<ScholarshipapplicationEntity> entityList = scholarshipapplicationDao.applyList(userId);
        //根据申请id  查询申请表中 教育/工作经历
        entityEach(entityList);
        return entityList;
    }

    @Override
    public boolean applyCheck(String userId, String applyrecordid) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("applyrecordid", applyrecordid);
        map.put("status", ApplicationStatusType.ApplySuccess);
        return scholarshipapplicationDao.applyExecute(map);
    }

    @Override
    public List<ScholarshipapplicationEntity> applySuccessList(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("status", ApplicationStatusType.ApplySuccess);
        List<ScholarshipapplicationEntity> entityList = scholarshipapplicationDao.applySuccessList(map);
        entityEach(entityList);
        return entityList;
    }

    private void entityEach(List<ScholarshipapplicationEntity> entityList) {
        entityList.forEach(entity -> {
            String applyGUID = entity.getGuid();
            //教育经历
            List<EducationexpireEntity> educationexpireEntities = educationexpireDao.eduListByScholarshipId(applyGUID);
            //工作经历
            List<WorkexpireEntity> workexpireEntities = workexpireDao.workexpireByScholarshipId(applyGUID);
            if (educationexpireEntities != null) {
                entity.setEducationList(educationexpireEntities);
            }
            if (workexpireEntities != null) {
                entity.setWorkList(workexpireEntities);
            }
        });
    }

}
