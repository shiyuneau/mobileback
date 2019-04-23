package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-21 21:13:02
 */
public class MessageEntity implements Serializable {
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
	private String content;
	/**
	 * 
	 */
	private String replyguid;
	/**
	 * 
	 */
	private String replycontent;
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
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setReplyguid(String replyguid) {
		this.replyguid = replyguid;
	}
	/**
	 * 获取：
	 */
	public String getReplyguid() {
		return replyguid;
	}
	/**
	 * 设置：
	 */
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	/**
	 * 获取：
	 */
	public String getReplycontent() {
		return replycontent;
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
