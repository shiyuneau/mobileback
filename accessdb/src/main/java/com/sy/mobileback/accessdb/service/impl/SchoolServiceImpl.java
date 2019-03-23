package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.CollegeEntity;
import com.sy.mobileback.accessdb.mapper.CollegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.sy.mobileback.accessdb.mapper.SchoolDao;
import com.sy.mobileback.accessdb.domain.SchoolEntity;
import com.sy.mobileback.accessdb.service.SchoolService;


@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private CollegeDao collegeDao;

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
}
