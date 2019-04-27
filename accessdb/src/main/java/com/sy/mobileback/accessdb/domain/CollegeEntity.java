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
public class CollegeEntity implements Serializable {
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
	private String schoolguid;
	/**
	 * 
	 */
	private String languageguid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer order;
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
	 * 语言名称
	 */
	private String languageName;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
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
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：
	 */
	public Integer getOrder() {
		return order;
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
}
