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
public class DestinationcountryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String sort;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String context;
	/**
	 * 
	 */
		private String guid;

	/**
	 * 设置：
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：
	 */
	public String getCountry() {
		return country;
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
	public void setContext(String context) {
		this.context = context;
	}
	/**
	 * 获取：
	 */
	public String getContext() {
		return context;
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
}
