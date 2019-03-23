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
public class ArticlecategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer sid;
	/**
	 * 
	 */
	private String languageguid;
	/**
	 * 
	 */
	private String tag;
	/**
	 * 
	 */
	private String parentguid;
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
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
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
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置：
	 */
	public void setParentguid(String parentguid) {
		this.parentguid = parentguid;
	}
	/**
	 * 获取：
	 */
	public String getParentguid() {
		return parentguid;
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
