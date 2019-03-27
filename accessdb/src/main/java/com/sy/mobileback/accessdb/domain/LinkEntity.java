package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-27 20:57:56
 */
public class LinkEntity implements Serializable {
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
	private String title;
	/**
	 * 
	 */
	private String image;
	/**
	 * 
	 */
	private String url;
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
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
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
