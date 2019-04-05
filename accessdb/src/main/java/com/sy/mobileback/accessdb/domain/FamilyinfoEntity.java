package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 学生家庭成员表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public class FamilyinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String studentguid;
	/**
	 * 
	 */
	private String studyabroadguid;
	/**
	 * 
	 */
	private String scholarshipguid;
	/**
	 * 家庭成员姓名
	 */
	private String familyname;
	/**
	 * 家庭成员年龄
	 */
	private String familyage;
	/**
	 * 江亭成员职务
	 */
	private String familyposition;
	/**
	 * 家庭成员电话
	 */
	private String familyphone;
	/**
	 * 家庭成员邮箱
	 */
	private String familyemail;
	/**
	 * 家庭成员工作单位
	 */
	private String familyworkplace;
	/**
	 * 与本人关系
	 */
	private String familycontace;

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
	 * 设置：
	 */
	public void setStudentguid(String studentguid) {
		this.studentguid = studentguid;
	}
	/**
	 * 获取：
	 */
	public String getStudentguid() {
		return studentguid;
	}
	/**
	 * 设置：
	 */
	public void setStudyabroadguid(String studyabroadguid) {
		this.studyabroadguid = studyabroadguid;
	}
	/**
	 * 获取：
	 */
	public String getStudyabroadguid() {
		return studyabroadguid;
	}
	/**
	 * 设置：
	 */
	public void setScholarshipguid(String scholarshipguid) {
		this.scholarshipguid = scholarshipguid;
	}
	/**
	 * 获取：
	 */
	public String getScholarshipguid() {
		return scholarshipguid;
	}
	/**
	 * 设置：家庭成员姓名
	 */
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	/**
	 * 获取：家庭成员姓名
	 */
	public String getFamilyname() {
		return familyname;
	}
	/**
	 * 设置：家庭成员年龄
	 */
	public void setFamilyage(String familyage) {
		this.familyage = familyage;
	}
	/**
	 * 获取：家庭成员年龄
	 */
	public String getFamilyage() {
		return familyage;
	}
	/**
	 * 设置：江亭成员职务
	 */
	public void setFamilyposition(String familyposition) {
		this.familyposition = familyposition;
	}
	/**
	 * 获取：江亭成员职务
	 */
	public String getFamilyposition() {
		return familyposition;
	}
	/**
	 * 设置：家庭成员电话
	 */
	public void setFamilyphone(String familyphone) {
		this.familyphone = familyphone;
	}
	/**
	 * 获取：家庭成员电话
	 */
	public String getFamilyphone() {
		return familyphone;
	}
	/**
	 * 设置：家庭成员邮箱
	 */
	public void setFamilyemail(String familyemail) {
		this.familyemail = familyemail;
	}
	/**
	 * 获取：家庭成员邮箱
	 */
	public String getFamilyemail() {
		return familyemail;
	}
	/**
	 * 设置：家庭成员工作单位
	 */
	public void setFamilyworkplace(String familyworkplace) {
		this.familyworkplace = familyworkplace;
	}
	/**
	 * 获取：家庭成员工作单位
	 */
	public String getFamilyworkplace() {
		return familyworkplace;
	}
	/**
	 * 设置：与本人关系
	 */
	public void setFamilycontace(String familycontace) {
		this.familycontace = familycontace;
	}
	/**
	 * 获取：与本人关系
	 */
	public String getFamilycontace() {
		return familycontace;
	}
}
