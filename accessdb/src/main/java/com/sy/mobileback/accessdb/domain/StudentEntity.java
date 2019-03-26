package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 19:09:22
 */
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private String countryguid;
	/**
	 * 
	 */
	private String educationguid;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String mail;
	/**
	 * 
	 */
	private String introduction;
	/**
	 * 
	 */
	private String passportnumber;
	/**
	 * 
	 */
	private String educationalexperience;
	/**
	 * 
	 */
	private Date createdtime;
	/**
	 * 
	 */
	private Date updatedtime;
	/**
	 * 
	 */
	private Integer deleted;
	/**
	 * 
	 */
	private String schoolguid;
	/**
	 * 
	 */
	private String isstar;

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
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * 获取：
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：
	 */
	public void setCountryguid(String countryguid) {
		this.countryguid = countryguid;
	}
	/**
	 * 获取：
	 */
	public String getCountryguid() {
		return countryguid;
	}
	/**
	 * 设置：
	 */
	public void setEducationguid(String educationguid) {
		this.educationguid = educationguid;
	}
	/**
	 * 获取：
	 */
	public String getEducationguid() {
		return educationguid;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取：
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置：
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：
	 */
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	/**
	 * 获取：
	 */
	public String getPassportnumber() {
		return passportnumber;
	}
	/**
	 * 设置：
	 */
	public void setEducationalexperience(String educationalexperience) {
		this.educationalexperience = educationalexperience;
	}
	/**
	 * 获取：
	 */
	public String getEducationalexperience() {
		return educationalexperience;
	}
	/**
	 * 设置：
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatedtime() {
		return updatedtime;
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
	public void setIsstar(String isstar) {
		this.isstar = isstar;
	}
	/**
	 * 获取：
	 */
	public String getIsstar() {
		return isstar;
	}
}
