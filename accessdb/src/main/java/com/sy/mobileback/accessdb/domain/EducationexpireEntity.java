package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 教育经历表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public class EducationexpireEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 学生
	 */
	private String studentguid;
	/**
	 * 留学ID
	 */
	private String studyabroadguid;
	/**
	 * 奖学金
	 */
	private String scholarshipguid;
	/**
	 * 开始时间
	 */
	private String educationfrom;
	/**
	 * 结束时间
	 */
	private String educationto;
	/**
	 * 就读学校
	 */
	private String educationschool;
	/**
	 * 专业或所获证书
	 */
	private String educationstudy;

	/**
	 * 所修专业
	 */
	private String educationfield;

	/**
	 * 入库顺序
	 */
	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getEducationfield() {
		return educationfield;
	}

	public void setEducationfield(String educationfield) {
		this.educationfield = educationfield;
	}

	/**
	 * 设置：
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	/**
	 * 获取：
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * 设置：学生
	 */
	public void setStudentguid(String studentguid) {
		this.studentguid = studentguid;
	}
	/**
	 * 获取：学生
	 */
	public String getStudentguid() {
		return studentguid;
	}
	/**
	 * 设置：留学ID
	 */
	public void setStudyabroadguid(String studyabroadguid) {
		this.studyabroadguid = studyabroadguid;
	}
	/**
	 * 获取：留学ID
	 */
	public String getStudyabroadguid() {
		return studyabroadguid;
	}
	/**
	 * 设置：奖学金
	 */
	public void setScholarshipguid(String scholarshipguid) {
		this.scholarshipguid = scholarshipguid;
	}
	/**
	 * 获取：奖学金
	 */
	public String getScholarshipguid() {
		return scholarshipguid;
	}
	/**
	 * 设置：开始时间
	 */
	public void setEducationfrom(String educationfrom) {
		this.educationfrom = educationfrom;
	}
	/**
	 * 获取：开始时间
	 */
	public String getEducationfrom() {
		return educationfrom;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEducationto(String educationto) {
		this.educationto = educationto;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEducationto() {
		return educationto;
	}
	/**
	 * 设置：就读学校
	 */
	public void setEducationschool(String educationschool) {
		this.educationschool = educationschool;
	}
	/**
	 * 获取：就读学校
	 */
	public String getEducationschool() {
		return educationschool;
	}
	/**
	 * 设置：专业或所获证书
	 */
	public void setEducationstudy(String educationstudy) {
		this.educationstudy = educationstudy;
	}
	/**
	 * 获取：专业或所获证书
	 */
	public String getEducationstudy() {
		return educationstudy;
	}
}
