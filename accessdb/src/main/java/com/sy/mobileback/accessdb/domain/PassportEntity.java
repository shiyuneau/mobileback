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
public class PassportEntity implements Serializable {
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
	private String passportid;
	/**
	 * 
	 */
	private String begindate;
	/**
	 * 
	 */
	private String enddate;
	/**
	 * 
	 */
	private String sex;
	/**
	 * 
	 */
	private String birth;
	/**
	 * 
	 */
	private String company;
	/**
	 * 
	 */
	private String position;

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
	public void setPassportid(String passportid) {
		this.passportid = passportid;
	}
	/**
	 * 获取：
	 */
	public String getPassportid() {
		return passportid;
	}
	/**
	 * 设置：
	 */
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	/**
	 * 获取：
	 */
	public String getBegindate() {
		return begindate;
	}
	/**
	 * 设置：
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	/**
	 * 获取：
	 */
	public String getEnddate() {
		return enddate;
	}
	/**
	 * 设置：
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * 获取：
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * 设置：
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：
	 */
	public String getPosition() {
		return position;
	}
}
