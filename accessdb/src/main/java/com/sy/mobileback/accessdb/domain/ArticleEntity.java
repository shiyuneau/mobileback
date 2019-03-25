package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public class ArticleEntity implements Serializable {
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
	private String categoryguid;
	/**
	 * 
	 */
	private String schoolguid;
	/**
	 * 
	 */
	private Integer order;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String brief;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer hits;
	/**
	 * 
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
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
	private String languageguid;
	/**
	 * 
	 */
	private String icon;

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
	public void setCategoryguid(String categoryguid) {
		this.categoryguid = categoryguid;
	}
	/**
	 * 获取：
	 */
	public String getCategoryguid() {
		return categoryguid;
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
	public void setBrief(String brief) {
		this.brief = brief;
	}
	/**
	 * 获取：
	 */
	public String getBrief() {
		return brief;
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
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：
	 */
	public Integer getHits() {
		return hits;
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
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：
	 */
	public String getIcon() {
		return icon;
	}
}
