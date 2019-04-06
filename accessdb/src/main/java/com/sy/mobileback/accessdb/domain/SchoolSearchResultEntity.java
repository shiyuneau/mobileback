package com.sy.mobileback.accessdb.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 23:11
 */
public class SchoolSearchResultEntity {
    private String shoolGuid;
    private String schoolName;
    private String professionName;
    private String professionGuid;
    private Integer academicSystem;
    /**
     * y有无将奖学金字段，-1未知，0无，1有，默认为-1，预留，数据库中找不到对应的字段
     */
    private Integer scholarship;

    public String getShoolGuid() {
        return shoolGuid;
    }

    public void setShoolGuid(String shoolGuid) {
        this.shoolGuid = shoolGuid;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getProfessionGuid() {
        return professionGuid;
    }

    public void setProfessionGuid(String professionGuid) {
        this.professionGuid = professionGuid;
    }

    public Integer getAcademicSystem() {
        return academicSystem;
    }

    public void setAcademicSystem(Integer academicSystem) {
        this.academicSystem = academicSystem;
    }

    public Integer getScholarship() {
        return scholarship;
    }

    public void setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
    }
}
