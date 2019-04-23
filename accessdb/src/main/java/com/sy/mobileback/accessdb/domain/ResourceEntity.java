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
public class ResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 
	 */
	private String objectguid;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String file;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Integer hits;

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
	public void setObjectguid(String objectguid) {
		this.objectguid = objectguid;
	}
	/**
	 * 获取：
	 */
	public String getObjectguid() {
		return objectguid;
	}
	/**
	 * 设置：
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public Date getDate() {
		return date;
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
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * 获取：
	 */
	public String getFile() {
		return file;
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
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：
	 */
	public Integer getHits() {
		return hits;
	}
}
