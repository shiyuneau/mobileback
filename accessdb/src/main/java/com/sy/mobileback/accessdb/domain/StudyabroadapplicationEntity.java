package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 12:41:19
 */
public class StudyabroadapplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 学生ID
	 */
	private String studentguid;
	/**
	 * 学校ID(原表中有，留存)
	 */
	private String school;
	/**
	 * 大学ID（原表数据，残留存） 此处接口中应该是 学校的 ID
	 */
	private String college;
	/**
	 * 专业ID
	 */
	private String profession;
	/**
	 * 照片
	 */
	private String photoid;
	/**
	 * 授课语言
	 */
	private String taughtby;
	/**
	 * 入学年份
	 */
	private String startyear;
	/**
	 * 经费来源
	 */
	private String fundingsource;
	/**
	 * 学历
	 */
	private String degree;
	/**
	 * 入学季节
	 */
	private String admissionseason;
	/**
	 * 英语能力,初步定义为汉字
	 */
	private String english;
	/**
	 * HSK等级
	 */
	private String hsk;
	/**
	 * 雅思
	 */
	private String ielts;
	/**
	 * 托福
	 */
	private String toefl;
	/**
	 * 推荐单位
	 */
	private String referenceby;
	/**
	 * 推荐单位电话
	 */
	private String referencetel;
	/**
	 * 经济担保人或机构
	 */
	private String finacial;
	/**
	 * 在华事务担保人
	 */
	private String guarantorin;
	/**
	 * 在华事务担保人电话
	 */
	private String guarantorintel;
	/**
	 * 监护人
	 */
	private String guardian;
	/**
	 * 护照文件存放位置
	 */
	private String validpassport;
	/**
	 * 最高学历证明存放位置
	 */
	private String graduatecertificate;
	/**
	 * 最高学历成绩单存放位置
	 */
	private String highestacademic;
	/**
	 * 专科成绩单/大学成绩单
	 */
	private String collegetranscript;
	/**
	 * 专科毕业证证/大学在学证明书
	 */
	private String juniorcollegedipint;
	/**
	 * 中文语言证书
	 */
	private String chineselanguagecertificate;
	/**
	 * 体验报告
	 */
	private String medicalreport;
	/**
	 * 学习计划
	 */
	private String studyplan;
	/**
	 * 本国家接到地址
	 */
	private String streetaddress;
	/**
	 * 本国家省/城市
	 */
	private String cityprovince;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 本国家邮箱
	 */
	private String countryemail;
	/**
	 * 本国家电话
	 */
	private String countryphone;
	/**
	 * 本国家邮编
	 */
	private String countryzipcode;
	/**
	 * 申请人邮箱
	 */
	private String applyemail;
	/**
	 * 申请人电话
	 */
	private String applyphone;
	/**
	 * 申请人现住址
	 */
	private String applyaddress;
	/**
	 * 申请人右边
	 */
	private String applyzipcode;
	/**
	 * 收件人姓名
	 */
	private String receivername;
	/**
	 * 收件人省市
	 */
	private String receivercity;
	/**
	 * 收件人地址
	 */
	private String receiveraddress;
	/**
	 * 收件人手机
	 */
	private String receiverphone;
	/**
	 * 收件人国家
	 */
	private String receivercountry;
	/**
	 * 收件人邮编
	 */
	private String receiverzipcode;
	/**
	 * 申请备注
	 */
	private String applicationnode;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 审计结果
	 */
	private String auditresult;
	/**
	 * 创建时间
	 */
	private Date createdtime;
	/**
	 * 修改时间
	 */
	private Date updatedtime;
	/**
	 * 删除
	 */
	private Integer deleted;
	/**
	 * 护照号(为了与前端对应，将PassportNumber改为PasswordNumber)
	 */
	private String passportcode;
	/**
	 * 护照姓名
	 */
	private String passportname;
	/**
	 * 护照到期时间
	 */
	private String passportexpire;
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
	private Integer emigrantfrom;
	/**
	 * 出生日期
	 */
	private String birth;
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

	private List<FamilyinfoEntity> familyList;
	private List<EducationexpireEntity> educationList;
	private List<WorkexpireEntity> workList;

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public List<FamilyinfoEntity> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<FamilyinfoEntity> familyList) {
		this.familyList = familyList;
	}

	public List<EducationexpireEntity> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<EducationexpireEntity> educationList) {
		this.educationList = educationList;
	}

	public List<WorkexpireEntity> getWorkList() {
		return workList;
	}

	public void setWorkList(List<WorkexpireEntity> workList) {
		this.workList = workList;
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
	/**
	 * 设置：学生ID
	 */
	public void setStudentguid(String studentguid) {
		this.studentguid = studentguid;
	}
	/**
	 * 获取：学生ID
	 */
	public String getStudentguid() {
		return studentguid;
	}
	/**
	 * 设置：学校ID(原表中有，留存)
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * 获取：学校ID(原表中有，留存)
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * 设置：大学ID（原表数据，残留存）
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * 获取：大学ID（原表数据，残留存）
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * 设置：专业ID
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：专业ID
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：照片
	 */
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	/**
	 * 获取：照片
	 */
	public String getPhotoid() {
		return photoid;
	}
	/**
	 * 设置：授课语言
	 */
	public void setTaughtby(String taughtby) {
		this.taughtby = taughtby;
	}
	/**
	 * 获取：授课语言
	 */
	public String getTaughtby() {
		return taughtby;
	}
	/**
	 * 设置：入学年份
	 */
	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}
	/**
	 * 获取：入学年份
	 */
	public String getStartyear() {
		return startyear;
	}
	/**
	 * 设置：经费来源
	 */
	public void setFundingsource(String fundingsource) {
		this.fundingsource = fundingsource;
	}
	/**
	 * 获取：经费来源
	 */
	public String getFundingsource() {
		return fundingsource;
	}
	/**
	 * 设置：学历
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * 获取：学历
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * 设置：入学季节
	 */
	public void setAdmissionseason(String admissionseason) {
		this.admissionseason = admissionseason;
	}
	/**
	 * 获取：入学季节
	 */
	public String getAdmissionseason() {
		return admissionseason;
	}
	/**
	 * 设置：英语能力,初步定义为汉字
	 */
	public void setEnglish(String english) {
		this.english = english;
	}
	/**
	 * 获取：英语能力,初步定义为汉字
	 */
	public String getEnglish() {
		return english;
	}
	/**
	 * 设置：HSK等级
	 */
	public void setHsk(String hsk) {
		this.hsk = hsk;
	}
	/**
	 * 获取：HSK等级
	 */
	public String getHsk() {
		return hsk;
	}
	/**
	 * 设置：雅思
	 */
	public void setIelts(String ielts) {
		this.ielts = ielts;
	}
	/**
	 * 获取：雅思
	 */
	public String getIelts() {
		return ielts;
	}
	/**
	 * 设置：托福
	 */
	public void setToefl(String toefl) {
		this.toefl = toefl;
	}
	/**
	 * 获取：托福
	 */
	public String getToefl() {
		return toefl;
	}
	/**
	 * 设置：推荐单位
	 */
	public void setReferenceby(String referenceby) {
		this.referenceby = referenceby;
	}
	/**
	 * 获取：推荐单位
	 */
	public String getReferenceby() {
		return referenceby;
	}
	/**
	 * 设置：推荐单位电话
	 */
	public void setReferencetel(String referencetel) {
		this.referencetel = referencetel;
	}
	/**
	 * 获取：推荐单位电话
	 */
	public String getReferencetel() {
		return referencetel;
	}
	/**
	 * 设置：经济担保人或机构
	 */
	public void setFinacial(String finacial) {
		this.finacial = finacial;
	}
	/**
	 * 获取：经济担保人或机构
	 */
	public String getFinacial() {
		return finacial;
	}
	/**
	 * 设置：在华事务担保人
	 */
	public void setGuarantorin(String guarantorin) {
		this.guarantorin = guarantorin;
	}
	/**
	 * 获取：在华事务担保人
	 */
	public String getGuarantorin() {
		return guarantorin;
	}
	/**
	 * 设置：在华事务担保人电话
	 */
	public void setGuarantorintel(String guarantorintel) {
		this.guarantorintel = guarantorintel;
	}
	/**
	 * 获取：在华事务担保人电话
	 */
	public String getGuarantorintel() {
		return guarantorintel;
	}
	/**
	 * 设置：监护人
	 */
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	/**
	 * 获取：监护人
	 */
	public String getGuardian() {
		return guardian;
	}
	/**
	 * 设置：护照文件存放位置
	 */
	public void setValidpassport(String validpassport) {
		this.validpassport = validpassport;
	}
	/**
	 * 获取：护照文件存放位置
	 */
	public String getValidpassport() {
		return validpassport;
	}
	/**
	 * 设置：最高学历证明存放位置
	 */
	public void setGraduatecertificate(String graduatecertificate) {
		this.graduatecertificate = graduatecertificate;
	}
	/**
	 * 获取：最高学历证明存放位置
	 */
	public String getGraduatecertificate() {
		return graduatecertificate;
	}
	/**
	 * 设置：最高学历成绩单存放位置
	 */
	public void setHighestacademic(String highestacademic) {
		this.highestacademic = highestacademic;
	}
	/**
	 * 获取：最高学历成绩单存放位置
	 */
	public String getHighestacademic() {
		return highestacademic;
	}
	/**
	 * 设置：专科成绩单/大学成绩单
	 */
	public void setCollegetranscript(String collegetranscript) {
		this.collegetranscript = collegetranscript;
	}
	/**
	 * 获取：专科成绩单/大学成绩单
	 */
	public String getCollegetranscript() {
		return collegetranscript;
	}
	/**
	 * 设置：中文语言证书
	 */
	public void setChineselanguagecertificate(String chineselanguagecertificate) {
		this.chineselanguagecertificate = chineselanguagecertificate;
	}
	/**
	 * 获取：中文语言证书
	 */
	public String getChineselanguagecertificate() {
		return chineselanguagecertificate;
	}
	/**
	 * 设置：体验报告
	 */
	public void setMedicalreport(String medicalreport) {
		this.medicalreport = medicalreport;
	}
	/**
	 * 获取：体验报告
	 */
	public String getMedicalreport() {
		return medicalreport;
	}
	/**
	 * 设置：学习计划
	 */
	public void setStudyplan(String studyplan) {
		this.studyplan = studyplan;
	}
	/**
	 * 获取：学习计划
	 */
	public String getStudyplan() {
		return studyplan;
	}
	/**
	 * 设置：本国家接到地址
	 */
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	/**
	 * 获取：本国家接到地址
	 */
	public String getStreetaddress() {
		return streetaddress;
	}
	/**
	 * 设置：本国家省/城市
	 */
	public void setCityprovince(String cityprovince) {
		this.cityprovince = cityprovince;
	}
	/**
	 * 获取：本国家省/城市
	 */
	public String getCityprovince() {
		return cityprovince;
	}
	/**
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：本国家邮箱
	 */
	public void setCountryemail(String countryemail) {
		this.countryemail = countryemail;
	}
	/**
	 * 获取：本国家邮箱
	 */
	public String getCountryemail() {
		return countryemail;
	}
	/**
	 * 设置：本国家电话
	 */
	public void setCountryphone(String countryphone) {
		this.countryphone = countryphone;
	}
	/**
	 * 获取：本国家电话
	 */
	public String getCountryphone() {
		return countryphone;
	}
	/**
	 * 设置：本国家邮编
	 */
	public void setCountryzipcode(String countryzipcode) {
		this.countryzipcode = countryzipcode;
	}
	/**
	 * 获取：本国家邮编
	 */
	public String getCountryzipcode() {
		return countryzipcode;
	}
	/**
	 * 设置：申请人邮箱
	 */
	public void setApplyemail(String applyemail) {
		this.applyemail = applyemail;
	}
	/**
	 * 获取：申请人邮箱
	 */
	public String getApplyemail() {
		return applyemail;
	}
	/**
	 * 设置：申请人电话
	 */
	public void setApplyphone(String applyphone) {
		this.applyphone = applyphone;
	}
	/**
	 * 获取：申请人电话
	 */
	public String getApplyphone() {
		return applyphone;
	}
	/**
	 * 设置：申请人现住址
	 */
	public void setApplyaddress(String applyaddress) {
		this.applyaddress = applyaddress;
	}
	/**
	 * 获取：申请人现住址
	 */
	public String getApplyaddress() {
		return applyaddress;
	}
	/**
	 * 设置：申请人右边
	 */
	public void setApplyzipcode(String applyzipcode) {
		this.applyzipcode = applyzipcode;
	}
	/**
	 * 获取：申请人右边
	 */
	public String getApplyzipcode() {
		return applyzipcode;
	}

	public String getJuniorcollegedipint() {
		return juniorcollegedipint;
	}

	public void setJuniorcollegedipint(String juniorcollegedipint) {
		this.juniorcollegedipint = juniorcollegedipint;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceivercity() {
		return receivercity;
	}

	public void setReceivercity(String receivercity) {
		this.receivercity = receivercity;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public String getReceiverphone() {
		return receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public String getReceivercountry() {
		return receivercountry;
	}

	public void setReceivercountry(String receivercountry) {
		this.receivercountry = receivercountry;
	}

	/**
	 * 设置：收件人邮编
	 */
	public void setReceiverzipcode(String receiverzipcode) {
		this.receiverzipcode = receiverzipcode;
	}
	/**
	 * 获取：收件人邮编
	 */
	public String getReceiverzipcode() {
		return receiverzipcode;
	}
	/**
	 * 设置：申请备注
	 */
	public void setApplicationnode(String applicationnode) {
		this.applicationnode = applicationnode;
	}
	/**
	 * 获取：申请备注
	 */
	public String getApplicationnode() {
		return applicationnode;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
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
	 * 设置：审计结果
	 */
	public void setAuditresult(String auditresult) {
		this.auditresult = auditresult;
	}
	/**
	 * 获取：审计结果
	 */
	public String getAuditresult() {
		return auditresult;
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
	 * 设置：修改时间
	 */
	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}
	/**
	 * 获取：修改时间
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

	public String getPassportexpire() {
		return passportexpire;
	}

	public void setPassportexpire(String passportexpire) {
		this.passportexpire = passportexpire;
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
	 * 设置：出生日期
	 */
	public void setBirth(String birth) {
		this.birth = birth;
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

	public String getPassportcode() {
		return passportcode;
	}

	public void setPassportcode(String passportcode) {
		this.passportcode = passportcode;
	}

	public Integer getEmigrantfrom() {
		return emigrantfrom;
	}

	public void setEmigrantfrom(Integer emigrantfrom) {
		this.emigrantfrom = emigrantfrom;
	}

	public String getBirth() {
		return birth;
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
}
