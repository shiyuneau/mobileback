package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private String guid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 性别(原表为gender,为了和前端统一，改为Sex)
	 */
	private Integer sex;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 身份
	 */
	private String avatar;
	/**
	 * 国家ID
	 */
	private String countryguid;
	/**
	 * 教育ID
	 */
	private String educationguid;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 电子邮件
	 */
	private String mail;
	/**
	 * 介绍
	 */
	private String introduction;
	/**
	 * 护照号(为了与前端对应，将PassportNumber改为PasswordNumber)
	 */
	private String passportno;
	/**
	 * 护照姓名
	 */
	private String passportname;
	/**
	 * 护照到期时间
	 */
	private Date expireat;
	/**
	 * 护照姓
	 */
	private String familyname;
	/**
	 * 护照名
	 */
	private String givenname;
	/**
	 * 最高学历
	 */
	private String highestdegree;
	/**
	 * 宗教
	 */
	private String religion;
	/**
	 * 国籍
	 */
	private String nationality;
	/**
	 * 母语
	 */
	private String mothertongue;
	/**
	 * 是否从中国大陆或港澳台地区移民：0否，1是
	 */
	private Integer emigrantflag;
	/**
	 * 出生日期
	 */
	private Date birthdate;
	/**
	 * 出生地点
	 */
	private String birthplace;
	/**
	 * 婚姻状态 0未婚，1已婚，2离异，3其他
	 */
	private Integer maritalstatus;
	/**
	 * 教育程度
	 */
	private String educationalexperience;
	/**
	 * 创建时间
	 */
	private Date createdtime;
	/**
	 * 更新时间
	 */
	private Date updatedtime;
	/**
	 * 删除
	 */
	private Integer deleted;
	/**
	 * 学校id
	 */
	private String schoolguid;
	/**
	 * 获得的表彰
	 */
	private String isstar;

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
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别(原表为gender,为了和前端统一，改为Sex)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(原表为gender,为了和前端统一，改为Sex)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：身份
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：身份
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：国家ID
	 */
	public void setCountryguid(String countryguid) {
		this.countryguid = countryguid;
	}
	/**
	 * 获取：国家ID
	 */
	public String getCountryguid() {
		return countryguid;
	}
	/**
	 * 设置：教育ID
	 */
	public void setEducationguid(String educationguid) {
		this.educationguid = educationguid;
	}
	/**
	 * 获取：教育ID
	 */
	public String getEducationguid() {
		return educationguid;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：电子邮件
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取：电子邮件
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：护照号(为了与前端对应，将PassportNumber改为PasswordNumber)
	 */
	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}
	/**
	 * 获取：护照号(为了与前端对应，将PassportNumber改为PasswordNumber)
	 */
	public String getPassportno() {
		return passportno;
	}
	/**
	 * 设置：护照姓名
	 */
	public void setPassportname(String passportname) {
		this.passportname = passportname;
	}
	/**
	 * 获取：护照姓名
	 */
	public String getPassportname() {
		return passportname;
	}
	/**
	 * 设置：护照到期时间
	 */
	public void setExpireat(Date expireat) {
		this.expireat = expireat;
	}
	/**
	 * 获取：护照到期时间
	 */
	public Date getExpireat() {
		return expireat;
	}
	/**
	 * 设置：护照姓
	 */
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	/**
	 * 获取：护照姓
	 */
	public String getFamilyname() {
		return familyname;
	}
	/**
	 * 设置：护照名
	 */
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	/**
	 * 获取：护照名
	 */
	public String getGivenname() {
		return givenname;
	}
	/**
	 * 设置：最高学历
	 */
	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}
	/**
	 * 获取：最高学历
	 */
	public String getHighestdegree() {
		return highestdegree;
	}
	/**
	 * 设置：宗教
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	/**
	 * 获取：宗教
	 */
	public String getReligion() {
		return religion;
	}
	/**
	 * 设置：国籍
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * 获取：国籍
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * 设置：母语
	 */
	public void setMothertongue(String mothertongue) {
		this.mothertongue = mothertongue;
	}
	/**
	 * 获取：母语
	 */
	public String getMothertongue() {
		return mothertongue;
	}
	/**
	 * 设置：是否从中国大陆或港澳台地区移民：0否，1是
	 */
	public void setEmigrantflag(Integer emigrantflag) {
		this.emigrantflag = emigrantflag;
	}
	/**
	 * 获取：是否从中国大陆或港澳台地区移民：0否，1是
	 */
	public Integer getEmigrantflag() {
		return emigrantflag;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	/**
	 * 设置：出生地点
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	/**
	 * 获取：出生地点
	 */
	public String getBirthplace() {
		return birthplace;
	}
	/**
	 * 设置：婚姻状态 0未婚，1已婚，2离异，3其他
	 */
	public void setMaritalstatus(Integer maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	/**
	 * 获取：婚姻状态 0未婚，1已婚，2离异，3其他
	 */
	public Integer getMaritalstatus() {
		return maritalstatus;
	}
	/**
	 * 设置：教育程度
	 */
	public void setEducationalexperience(String educationalexperience) {
		this.educationalexperience = educationalexperience;
	}
	/**
	 * 获取：教育程度
	 */
	public String getEducationalexperience() {
		return educationalexperience;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatedtime() {
		return updatedtime;
	}
	/**
	 * 设置：删除
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：删除
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * 设置：学校id
	 */
	public void setSchoolguid(String schoolguid) {
		this.schoolguid = schoolguid;
	}
	/**
	 * 获取：学校id
	 */
	public String getSchoolguid() {
		return schoolguid;
	}
	/**
	 * 设置：获得的表彰
	 */
	public void setIsstar(String isstar) {
		this.isstar = isstar;
	}
	/**
	 * 获取：获得的表彰
	 */
	public String getIsstar() {
		return isstar;
	}
}
