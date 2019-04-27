package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 22:54:38
 */
public class ProfessionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String managerguid;
	/**
	 * 
	 */
	private String collegeguid;
	/**
	 * 
	 */
	private String languageguid;
	private String languageName;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer sid;
	/**
	 * 
	 */
	private String academicsystem;
	/**
	 * 
	 */
	private String introduction;
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
	private Double amount;
	/**
	 * 
	 */
	private Integer isdegree;

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
	public void setManagerguid(String managerguid) {
		this.managerguid = managerguid;
	}
	/**
	 * 获取：
	 */
	public String getManagerguid() {
		return managerguid;
	}
	/**
	 * 设置：
	 */
	public void setCollegeguid(String collegeguid) {
		this.collegeguid = collegeguid;
	}
	/**
	 * 获取：
	 */
	public String getCollegeguid() {
		return collegeguid;
	}
	/**
	 * 设置：
	 */
	public void setLanguageguid(String languageguid) {
		this.languageguid = languageguid;
	}
	/**
	 * 获取：
	 */
	public String getLanguageguid() {
		return languageguid;
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
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * 获取：
	 */
	public Integer getSid() {
		return sid;
	}
	/**
	 * 设置：
	 */
	public void setAcademicsystem(String academicsystem) {
		this.academicsystem = academicsystem;
	}
	/**
	 * 获取：
	 */
	public String getAcademicsystem() {
		return academicsystem;
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
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setIsdegree(Integer isdegree) {
		this.isdegree = isdegree;
	}
	/**
	 * 获取：
	 */
	public Integer getIsdegree() {
		return isdegree;
	}
}
