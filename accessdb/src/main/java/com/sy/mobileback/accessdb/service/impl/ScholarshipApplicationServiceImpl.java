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
import com.sy.mobileback.common.utils.JsonResult;
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

    /**
     * 根据指定得 管理员id和申请ID，对申请进行 审核 , appResultType 为1 ，代表审核成功， 为0 代表拒绝审批
     * @param userFlag
     * @param applyrecordid
     * @return
     */
    @Override
    public boolean applyCheck(int userFlag, String applyrecordid , int applyResultType , String applyAdvice) {
        Map<String, Object> map = new HashMap<>();
        map.put("applyrecordid", applyrecordid);
        if (userFlag == 1) {
            // 高校管理员
            if (applyResultType == 0) {
                map.put("status", ApplicationStatusType.SCHOOLApplyFail.getType());
            }
            if (applyResultType == 1) {
                map.put("status", ApplicationStatusType.SCHOOLApplySuccess.getType());
            }
            if (applyResultType == -1) {
                map.put("status", ApplicationStatusType.ApplyRewrite.getType());
            }
        } else if (userFlag == 2) {
            // 教委人员
            if (applyResultType == 0 ) {
                map.put("status", ApplicationStatusType.JWApplyFail.getType());
                map.put("applyAdvice",applyAdvice);
            }
            if (applyResultType == 1) {
                map.put("status", ApplicationStatusType.JWApplySuccess.getType());
            }
        }
        Timestamp updateTime = DateUtils.getDBTime();
        map.put("updateTime",updateTime);
        return scholarshipapplicationDao.applyCheck(map);
    }

    /**
     * 返回待审核的数据，其中 userFlag 为 1 ，返回高校待审核 列表
     * userFlag 为 2 ，返回 教委带审核列表
     * @param managerGUID
     * @param userFlag
     * @return
     */
    @Override
    public List<ScholarshipapplicationEntity> applyApplyedList(String managerGUID,int userFlag) {
        Map<String, Object> map = new HashMap<>();
        map.put("managerGUID", managerGUID);
        if (userFlag == 1) {
            map.put("status", ApplicationStatusType.HasApply.getType());
            map.put("userFlag",1);
            // 还要返回教委审核不通过的
            map.put("jwbhstatus",ApplicationStatusType.JWApplyFail.getType());
        } else if (userFlag == 2) {
            map.put("status", ApplicationStatusType.SCHOOLApplySuccess.getType());
            map.put("userFlag",2);
        }
        List<ScholarshipapplicationEntity> entityList = scholarshipapplicationDao.applyApplyedList(map);
        entityEach(entityList);
        return entityList;
    }

    /**
     * 更新奖学金的申请信息
     * @param entity
     * @param userid
     * @return
     */
    @Override
    public boolean sholarshipApplyUpdate(ScholarshipapplicationEntity entity, String userid) {
        Timestamp dbTime = DateUtils.getDBTime();
        entity.setUpdatedtime(dbTime);
        entity.setStatus(1);
        List<EducationexpireEntity> educationList = entity.getEducationList();
        List<WorkexpireEntity> workList = entity.getWorkList();
        try {
            scholarshipapplicationDao.scholarshipapplicationUpdate(entity);
            educationexpireDao.educationexpireBatchUpdate(educationList);
            workexpireDao.workexpireBatchUpdate(workList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 返回奖学金 申请单的统计数量 ， 如果是教委，不传递 userId
     * @param userFlag
     * @param userId
     * @return
     */
    @Override
    public JsonResult scholarshipApplyCount(int userFlag, String userId) {
        List<Integer> statusList = null;
        Map<String, Object> map = new HashMap<>();
        if (userFlag == 1) {
            map.put("managerGUID", userId);
        }
        try {
            statusList = scholarshipapplicationDao.allStatusByGUID(map);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台错误");
        }
        if (null==statusList) {
            return JsonResult.error("后台错误");
        }
        int applying = 0;
        int applySuccess = 0;
        int applyReject = 0;
        if (userFlag == 1) {
            // 对于高校，待审核的 为status=1的
            // 已经批准 为 status=2，status=5，status=6
            // 高校驳回的 为 status = 3 ， status = -1
            for (Integer status : statusList) {
                if (status == 1) {
                    applying++;
                }
                if (status == 2 || status == 5 || status == 6) {
                    applySuccess++;
                }
                if (status == 3 || status == -1) {
                    applyReject++;
                }
            }
        } else if (userFlag == 2) {
            for (Integer status : statusList) {
                if (status == 2) {
                    applying++;
                }
                if (status == 5) {
                    applySuccess++;
                }
                if (status == 6) {
                    applyReject++;
                }
            }
        }
        int applyTotal = applying + applySuccess + applyReject;
        JsonResult result = JsonResult.ok();
        result.put("allApply",applyTotal);
        result.put("applying",applying);
        result.put("applySuccess",applySuccess);
        result.put("applyReject",applyReject);
        return result;
    }

    @Override
    public Integer applyCountByStudentGUID(String userid) {
        return scholarshipapplicationDao.applyCountByStudentGUID(userid);
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
