package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public class AlumniEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String schoolguid;

	private String professionguid;
	/**
	 * 
	 */
	private String studentguid;
	/**
	 * 
	 */
	private Integer isstar;
	/**
	 * 
	 */
	private Integer deleted;

	/**
	 * 姓名
	 */
	private String aluminName;

	/**
	 * 学校名称
	 */
	private String aluminSchoolName;

	/**
	 * 专业名称
	 */
	private String professionName;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 邮箱
	 */
	private String mail;

	/**
	 * 个人介绍
	 */
	private String introduction;



	public String getProfessionguid() {
		return professionguid;
	}

	public void setProfessionguid(String professionguid) {
		this.professionguid = professionguid;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAluminName() {
		return aluminName;
	}

	public void setAluminName(String aluminName) {
		this.aluminName = aluminName;
	}

	public String getAluminSchoolName() {
		return aluminSchoolName;
	}

	public void setAluminSchoolName(String aluminSchoolName) {
		this.aluminSchoolName = aluminSchoolName;
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
	 * 设置：
	 */
	public void setSchoolguid(String schoolguid) {
		this.schoolguid = schoolguid;
	}
	/**
	 * 获取：
	 */
	public String getSchoolguid() {
		return schoolguid;
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
	public void setIsstar(Integer isstar) {
		this.isstar = isstar;
	}
	/**
	 * 获取：
	 */
	public Integer getIsstar() {
		return isstar;
	}
	/**
	 * 设置：
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：
	 */
	public Integer getDeleted() {
		return deleted;
	}
}
