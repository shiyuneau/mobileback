package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.CollegeEntity;
import com.sy.mobileback.accessdb.domain.ProfessionEntity;
import com.sy.mobileback.accessdb.domain.SchoolEntity;
import com.sy.mobileback.accessdb.domain.SchoolSearchResultEntity;
import com.sy.mobileback.accessdb.mapper.CollegeDao;
import com.sy.mobileback.accessdb.mapper.ProfessionDao;
import com.sy.mobileback.accessdb.mapper.SchoolDao;
import com.sy.mobileback.accessdb.service.SchoolService;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private ProfessionDao professionDao;

    /**
     * 获取 大学及大学得专业，实现方式。 从 school 表中 获取 学校 得 集合，
     * 再从college 表中获取 专业得集合，
     * 根据SchoolGUID进行匹配，关联
     * @return
     */
    @Override
    public List<SchoolEntity> schoolList() {
        List<SchoolEntity> schools = schoolDao.schoolList();
        List<CollegeEntity> colleges = collegeDao.collegeList();

        for(SchoolEntity school : schools) {
            String schoolGuid = school.getGuid();
            if (null==schoolGuid) {
                continue;
            }
            for (CollegeEntity college: colleges) {
                String collegeSchoolguid = college.getSchoolguid();
                if (null==collegeSchoolguid) {
                    continue;
                }
                if (schoolGuid.equals(collegeSchoolguid)) {
                    // 当前得college是当前school得专业，先判断当前school有无collegeList
                    List<CollegeEntity> list = school.getColleges();
                    if (null==list) {
                        list = new ArrayList<>();
                    }
                    list.add(college);
                    school.setColleges(list);
                }

            }
        }
        return schools;
    }

    @Override
    public SchoolEntity schoolDetail(String schoolGuid) {
        return schoolDao.schoolDetail(schoolGuid);
    }

    @Override
    public List<SchoolEntity> schools() {
        return schoolDao.schoolList();
    }

    @Override
    public List<SchoolSearchResultEntity> schoolSearch(Map<String, Object> map) {
        List<SchoolSearchResultEntity> list = schoolDao.schoolSearch(map);
        list.forEach(entity -> entity.setScholarship(-1));
        return list;
    }

    @Override
    public List<String> schoolByManagerguid(String userId) {
        return schoolDao.schoolByManagerguid(userId);
    }

    /**
     * 根据 管理员的id，查询出学校的简介 , 不确定一个高校管理者有多少个学校，目前返回一个list
     * @param managerGUID
     * @return
     */
    @Override
    public JsonResult introductionByMangerGUID(String managerGUID) {

        try {
            List<SchoolEntity> list = schoolDao.schoolListByManager(managerGUID);
            JsonResult result = JsonResult.ok();
            result.put("entity",list.size()>0?list.get(0):null);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台处理出错");
        }
    }

    /**
     * 根据 高校管理者返回学院的简介及其他信息
     * 两种方式，一种是通过 managerid查询学校，再根据学校去关联学院
     * 另一种 ，直接从学院的表中查找出managerguid对应的学院，目前按第二种实现
     * @param managerGUID
     * @return
     */
    @Override
    public JsonResult collegeinfoByMangerGUID(String managerGUID) {
        try {
            List<CollegeEntity> list = collegeDao.collegeinfoByMangerGUID(managerGUID);
            JsonResult result = JsonResult.ok();
            result.put("entity",list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台处理出错");
        }
    }

    /**
     * 根据 高校管理者返回学院的简介及其他信息
     * @param managerGUID
     * @return
     */
    @Override
    public JsonResult professioninfoByMangerGUID(String managerGUID) {
        try {
            List<ProfessionEntity> list = professionDao.professioninfoByMangerGUID(managerGUID);
            JsonResult result = JsonResult.ok();
            result.put("entity",list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("后台处理出错");
        }
    }
}
