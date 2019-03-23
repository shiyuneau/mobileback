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
