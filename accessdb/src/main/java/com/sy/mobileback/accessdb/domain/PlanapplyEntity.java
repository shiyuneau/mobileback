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
public class PlanapplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 工作单位全称
	 */
	private String company;
	/**
	 * 地址及邮编
	 */
	private String address;
	/**
	 * 报名团组序号及主题
	 */
	private String title;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 部门及职务
	 */
	private String position;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 行政级别
	 */
	private String level;
	/**
	 * 出生日期
	 */
	private String birth;
	/**
	 * 名族
	 */
	private String nation;
	/**
	 * 办公电话
	 */
	private String tel;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 
	 */
	private String email;
	/**
	 * 是否已落实2019年度因公出国（境）经费预算
	 */
	private String isno;
	/**
	 * 出访手续具体联系人
	 */
	private String lianxiren;
	/**
	 * 电话/座机
	 */
	private String lianxirenmobile;
	/**
	 * 出访必要性
	 */
	private String necessity;

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
	 * 设置：工作单位全称
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：工作单位全称
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：地址及邮编
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址及邮编
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：报名团组序号及主题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：报名团组序号及主题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：部门及职务
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：部门及职务
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：行政级别
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：行政级别
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * 获取：出生日期
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * 设置：名族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：名族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：办公电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：办公电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：是否已落实2019年度因公出国（境）经费预算
	 */
	public void setIsno(String isno) {
		this.isno = isno;
	}
	/**
	 * 获取：是否已落实2019年度因公出国（境）经费预算
	 */
	public String getIsno() {
		return isno;
	}
	/**
	 * 设置：出访手续具体联系人
	 */
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	/**
	 * 获取：出访手续具体联系人
	 */
	public String getLianxiren() {
		return lianxiren;
	}
	/**
	 * 设置：电话/座机
	 */
	public void setLianxirenmobile(String lianxirenmobile) {
		this.lianxirenmobile = lianxirenmobile;
	}
	/**
	 * 获取：电话/座机
	 */
	public String getLianxirenmobile() {
		return lianxirenmobile;
	}
	/**
	 * 设置：出访必要性
	 */
	public void setNecessity(String necessity) {
		this.necessity = necessity;
	}
	/**
	 * 获取：出访必要性
	 */
	public String getNecessity() {
		return necessity;
	}
}
