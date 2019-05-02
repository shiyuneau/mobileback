package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.*;
import com.sy.mobileback.accessdb.mapper.EducationexpireDao;
import com.sy.mobileback.accessdb.mapper.FamilyinfoDao;
import com.sy.mobileback.accessdb.mapper.StudyabroadapplicationDao;
import com.sy.mobileback.accessdb.mapper.WorkexpireDao;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.enums.ApplicationStatusType;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.DateUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 14:29
 */

@Transactional(rollbackFor = Exception.class)
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String studyabroadApply(String userid, StudyabroadapplicationEntity entity) {
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
            return null;
        }

        return applyUUID;
    }

    /**
     * 根据用户ID　和申请ID 同时去删除一条数据，防止 用户和申请表不匹配的情况
     * 取消的 状态就是 数据库中 status 的 值 为 4
     *
     * @param userid
     * @param applyid
     * @return
     */
    @Override
    public boolean applyCancel(String userid, String applyid) {
        //
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("applyid", applyid);
        map.put("status", ApplicationStatusType.UserCancelApply.getType());

        return studyabroadapplicationDao.applyCancel(map);
    }

    /**
     * 首先根据用户的 userid 查询所有的申请表的ID，　根据申请表中的每个申请ID，去其他两张表找其他的信息
     *
     * @param userid
     * @return
     */
    @Override
    public List<StudyabroadapplicationEntity> studentApplyList(String userid) {
        // 此处的方式是 遍历每一个apply，再根据 guid去数据库查找，
        // 另外一种实现 减少数据库查询，直接根据用户的id把所有的 信息取出来，直接在for循环去比较
        List<StudyabroadapplicationEntity> entityList = studyabroadapplicationDao.applyList(userid);
        entityEach(entityList);
        return entityList;
    }

    private void entityEach(List<StudyabroadapplicationEntity> entityList) {
        entityList.forEach(entity -> {
            String studyabroadGUID = entity.getGuid();
//            String collegeID = entity.getCo
            List<EducationexpireEntity> educationList = educationexpireDao.educationExpireList(studyabroadGUID);
            List<WorkexpireEntity> workList = workexpireDao.workExpireList(studyabroadGUID);
            List<FamilyinfoEntity> familyList = familyinfoDao.familyList(studyabroadGUID);
            if (null != educationList) {
                entity.setEducationList(educationList);
            }
            if (null != workList) {
                entity.setWorkList(workList);
            }
            if (null != familyList) {
                entity.setFamilyList(familyList);
            }
        });
    }

    /**
     * 根据指定得 管理员id和申请ID，对申请进行 审核 , appResultType 为1 ，代表审核成功， 为0 代表拒绝审批
     *
     * @param userId
     * @param applyid
     * @return
     */
    @Override
    public boolean applyCheck(String userId, String applyid, int appResultType) {

        Map<String, Object> map = new HashMap<>();
        map.put("applyid", applyid);
        if (appResultType == 1) {
            map.put("status", ApplicationStatusType.SCHOOLApplySuccess.getType());
        } else if (appResultType == 0) {
            map.put("status", ApplicationStatusType.SCHOOLApplyFail.getType());
        }
        Timestamp updateTime = DateUtils.getDBTime();
        map.put("updateTime", updateTime);
        return studyabroadapplicationDao.applyCheck(map);
    }

    /**
     * 返回带申请得申请列表
     *
     * @param managerGUID
     * @return
     */
    @Override
    public List<StudyabroadapplicationEntity> applyApplyedList(String managerGUID) {
        Map<String, Object> map = new HashMap<>();
        map.put("managerGUID", managerGUID);
        map.put("status", ApplicationStatusType.HasApply.getType());
        List<StudyabroadapplicationEntity> entityList = studyabroadapplicationDao.applyApplyedList(map);
        entityEach(entityList);
        return entityList;
    }

    @Override
    public Integer applyCountByStudentGUID(String userid) {
        return studyabroadapplicationDao.applyCountByStudentGUID(userid);
    }

    /**
     * 统计留学申请的审批情况
     *
     * @param userFlag
     * @return
     */
    @Override
    public JsonResult studyabroadApplyCount(int userFlag, String managerGUID) {
        List<Integer> statusList = null;
        try {
            statusList = studyabroadapplicationDao.allStatusByGUID(managerGUID);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台错误");
        }
        if (null == statusList) {
            return JsonResult.error("后台错误");
        }
        int applying = 0;
        int applySuccess = 0;
        int applyReject = 0;
        if (statusList.size() > 0) {
            for (Integer status : statusList) {
                if (status == 1) {
                    applying++;
                }
                if (status == 2) {
                    applySuccess++;
                }
                if (status == 3) {
                    applyReject++;
                }
            }
        }
        JsonResult result = JsonResult.ok();
        result.put("allApply", statusList.size());
        result.put("applying", applying);
        result.put("applySuccess", applySuccess);
        result.put("applyReject", applyReject);
        return result;
    }

    @Override
    public JsonResult studyabroadApplyListByPage(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = studyabroadapplicationDao.studyabroadApplyCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<StudyabroadapplicationEntity> list = studyabroadapplicationDao.studyabroadApplyListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }


    /**
     * 根据 type 的不同，分别 按 国籍、专业、学校统计学生数量
     * type = 1 国籍
     * type = 2 学校
     * type = 3 专业
     *
     * @param type
     * @return
     */
    @Override
    public JsonResult studyaboardAnalysis(Integer type) {
        List<AnalysisEntity> analysisList = null;
        try {
            int applySuccessed = studyabroadapplicationDao.studyabroadApplySuccessCount();

            if (type == 1) {
                analysisList = studyabroadapplicationDao.countByNationality();
            } else if (type == 2) {
                analysisList = studyabroadapplicationDao.countBySchool();
            } else if (type == 3) {
                analysisList = studyabroadapplicationDao.countByProfession();
            }
            if (null == analysisList || applySuccessed == 0) {
                return JsonResult.ok().put("msg", "查询成功，但暂无审批成功的申请单");
            }
            for (AnalysisEntity entity : analysisList) {
                float count = entity.getCount();

                float percent = count / applySuccessed;
                BigDecimal b = new BigDecimal(percent);
                percent = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                entity.setPercent(percent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台查询出错");
        }
        JsonResult result = JsonResult.ok();
        result.put("rows", analysisList);
        return result;
    }

    /**
     * 按 没年 返回当前学校用户的 所有成功审批的信息
     * @param managerGUID
     * @return
     */
    @Override
    public JsonResult studyOfferByYear(String managerGUID){
        JsonResult result = JsonResult.error("后台错误");
        try {
            List<StudyabroadapplicationEntity> entityList = studyabroadapplicationDao.studyOfferByYear(managerGUID);
            if (entityList !=null ) {
                return JsonResult.ok().put("rows",entityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
