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
public class ScholarshipapplicationEntity implements Serializable {
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
	 * 奖学金ID
	 */
	private String scholarshipguid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createdtime;
	/**
	 * 更新时间
	 */
	private Date updatedtime;
	/**
	 * 删除标记
	 */
	private Integer deleted;
	/**
	 * 家族名称
	 */
	private String familyname;
	/**
	 * 名字
	 */
	private String givenname;
	/**
	 * 国家ID
	 */
	private String nationalityguid;
	/**
	 * 出生日期
	 */
	private String birth;
	/**
	 * 出生国ID
	 */
	private String birthcountryguid;

	/**
	 * 城市 原city
	 */
	private String birthcity;
	/**
	 * 婚姻状况
	 */
	private Integer maritalstatus;
	/**
	 * 本土语言
	 */
	private String nativelanguage;
	/**
	 * 宗教
	 */
	private String religion;
	/**
	 * 所在国家ID
	 */
	private String addresscountryguid;
	/**
	 * 当前所在地址
	 */
	private String presentaddress;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 邮编
	 */
	private String passport;
	/**
	 * 所在学校
	 */
	private String educationschool;
	/**
	 * 所在学院
	 */
	private String educationprofessional;
	/**
	 * 证书
	 */
	private String certificates;
	/**
	 * 就业记录
	 */
	private String employmentrecord;
	/**
	 * 汉语等级 原chinesely
	 */
	private String chinese;
	/**
	 * 英语等级 原englishly
	 */
	private String english;
	/**
	 * 汉语分数
	 */
	private String chinesescore;
	/**
	 * 其他语言 原otherlanguages
	 */
	private String otherlanguage;
	/**
	 * 是否在中国工作
	 */
	private String workedinchina;
	/**
	 * 学生类型
	 */
	private String studenttype;
	/**
	 * 综合学校
	 */
	private String apllyschool;
	/**
	 * 专业
	 */
	private String apllyprofessional;
	/**
	 * 学习计划
	 */
	private String studyplan;
	/**
	 * 毕业计划
	 */
	private String graduationplan;
	/**
	 * 产品
	 */
	private String production;
	/**
	 * 奖学金申请
	 */
	private String scholarshipapplied;
	/**
	 * 职业
	 */
	private String organization;
	/**
	 * 申请人在华事务联系人或机构名称
	 */
	private String contactname;
	/**
	 * 申请人在华事务联系人或机构电话
	 */
	private String contacttel;
	/**
	 * 申请人在华事务联系人或机构传真
	 */
	private String contactfax;
	/**
	 * 申请人在华事务联系人或机构地址
	 */
	private String contactaddress;
	/**
	 * email
	 */
	private String email;
	/**
	 * 配偶姓名
	 */
	private String spousename;
	/**
	 * 配偶年龄
	 */
	private String spouseage;
	/**
	 * 配偶国籍
	 */
	private String spousecountry;
	/**
	 * 配偶职业 原spouseoccupation
	 */
	private String spouseemployment;
	/**
	 * 配偶受教育程度
	 */
	private String spouseeducation;
	/**
	 * 父亲姓名
	 */
	private String fathername;
	/**
	 * 父亲年龄
	 */
	private String fatherage;
	/**
	 * 父亲国籍
	 */
	private String fathercountry;
	/**
	 * 父亲职业 fatheroccupation
	 */
	private String fatheremploymnet;
	/**
	 * 父亲受教育程度
	 */
	private String fathereducation;
	/**
	 * 母亲姓名
	 */
	private String mothername;
	/**
	 * 母亲年龄
	 */
	private String motherage;
	/**
	 * 母亲国籍
	 */
	private String mothercountry;
	/**
	 * 母亲职业 原motheroccupation
	 */
	private String motheremployment;
	/**
	 * 母亲受教育程度
	 */
	private String mothereducation;
	/**
	 * 推荐院校
	 */
	private String recominstitutions;
	/**
	 * 联系人电话
	 */
	private String phone;
	/**
	 * 奖学金项目
	 */
	private String project;
	/**
	 * 奖学金类型
	 */
	private String type;
	/**
	 * 学生层次
	 */
	private String level;
	/**
	 * 申报专业
	 */
	private String decprofession;
	/**
	 * 奖学金申请照片id
	 */
	private String photoid;
	/**
	 * 申请人传真
	 */
	private String fax;
	/**
	 * 永久通信地址
	 */
	private String premanentaddres;
	/**
	 * 教育经历id
	 */
	private List<EducationexpireEntity> educationList;
	/**
	 * 工作经历id
	 */
	private List<WorkexpireEntity> workList;

	/**
	 * hsk考试登记或其他类型汉语考试成绩
	 */
	private String hsk;
	/**
	 * 是否可以用英语学习
	 */
	private String canstudy;
	/**
	 * 申请来华学习专业
	 */
	private String subject;
	/**
	 * 申请院校
	 */
	private String educationchina;
	/**
	 * 申请专业学习时间起
	 */
	private String studystart;
	/**
	 * 申请专业学习时间终
	 */
	private String studyend;
	/**
	 * 是否需要补习汉语
	 */
	private String needstudychinese;
	/**
	 * 是否需要补习汉语的补习时间(是的答案)
	 */
	private String needstudychinesetime;
	/**
	 * 其他的(否的答案)
	 */
	private String other;
	/**
	 * 拟在华学习或研究的详细内容
	 */
	private String otherplan;
	/**
	 * 曾发表的主要学术论文、著作及作品
	 */
	private String otherpublished;
	/**
	 * 推荐您申请天津市政府奖学金的机构或个人
	 */
	private String scholarship;
	/**
	 * 申请人是否曾在华学习和任职
	 */
	private String studiedorwork;
	/**
	 * 学习或任职单位
	 */
	private String institutionoremployer;
	/**
	 * 在华起止时间
	 */
	private String starttimechina;
	/**
	 * 在华终止时间
	 */
	private String endtimechina;
	/**
	 * 推荐信1
	 */
	private String recom1;
	/**
	 * 推荐信2
	 */
	private String recom2;
	/**
	 * 有关中国院校接受函或录取通知书
	 */
	private String notice;
	/**
	 * 本人最后学历成绩单复印件（须公证）
	 */
	private String schoolreport;
	/**
	 * 本人最后学历证书复印件（须公证）
	 */
	private String diploma;
	/**
	 * （本科/，硕士，博士，其它）
	 */
	private String diplomatype;
	/**
	 * 外国人体格检查记录
	 */
	private String examination;
	/**
	 * 来华学习计划
	 */
	private String planchina;
	/**
	 * 所发表的文章等
	 */
	private String article;
	/**
	 * 其他附件
	 */
	private String otherannex;
	/**
	 * 类型
	 */
	private Integer scholarshiptype;
	/**
	 * 审计结果
	 */
	private String auditresult;
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
	 * 最高学历
	 */
	private String highestdegree;
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
	 * 出生地点
	 */
	private String birthplace;
	/**
	 * 教育程度
	 */
	private String educationalexperience;
    /**
     * 性别
     */
    private String sex;
    /**
     * 婚姻
     */
    private String marriage;
    /**
     * 出生国
     */
    private String birthcountry;

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
	 * 设置：奖学金ID
	 */
	public void setScholarshipguid(String scholarshipguid) {
		this.scholarshipguid = scholarshipguid;
	}
	/**
	 * 获取：奖学金ID
	 */
	public String getScholarshipguid() {
		return scholarshipguid;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
	 * 设置：删除标记
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：删除标记
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * 设置：家族名称
	 */
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	/**
	 * 获取：家族名称
	 */
	public String getFamilyname() {
		return familyname;
	}
	/**
	 * 设置：名字
	 */
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}
	/**
	 * 获取：名字
	 */
	public String getGivenname() {
		return givenname;
	}
	/**
	 * 设置：国家ID
	 */
	public void setNationalityguid(String nationalityguid) {
		this.nationalityguid = nationalityguid;
	}
	/**
	 * 获取：国家ID
	 */
	public String getNationalityguid() {
		return nationalityguid;
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
	 * 设置：出生国ID
	 */
	public void setBirthcountryguid(String birthcountryguid) {
		this.birthcountryguid = birthcountryguid;
	}
	/**
	 * 获取：出生国ID
	 */
	public String getBirthcountryguid() {
		return birthcountryguid;
	}
	/**
	 * 设置：所在城市
	 */
	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}
	/**
	 * 获取：所在城市
	 */
	public String getBirthcity() {
		return birthcity;
	}
	/**
	 * 设置：婚姻状况
	 */
	public void setMaritalstatus(Integer maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	/**
	 * 获取：婚姻状况
	 */
	public Integer getMaritalstatus() {
		return maritalstatus;
	}
	/**
	 * 设置：本土语言
	 */
	public void setNativelanguage(String nativelanguage) {
		this.nativelanguage = nativelanguage;
	}
	/**
	 * 获取：本土语言
	 */
	public String getNativelanguage() {
		return nativelanguage;
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
	 * 设置：所在国家ID
	 */
	public void setAddresscountryguid(String addresscountryguid) {
		this.addresscountryguid = addresscountryguid;
	}
	/**
	 * 获取：所在国家ID
	 */
	public String getAddresscountryguid() {
		return addresscountryguid;
	}
	/**
	 * 设置：地址
	 */
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	/**
	 * 获取：地址
	 */
	public String getPresentaddress() {
		return presentaddress;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：邮编
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
	/**
	 * 获取：邮编
	 */
	public String getPassport() {
		return passport;
	}
	/**
	 * 设置：所在学校
	 */
	public void setEducationschool(String educationschool) {
		this.educationschool = educationschool;
	}
	/**
	 * 获取：所在学校
	 */
	public String getEducationschool() {
		return educationschool;
	}
	/**
	 * 设置：所在学院
	 */
	public void setEducationprofessional(String educationprofessional) {
		this.educationprofessional = educationprofessional;
	}
	/**
	 * 获取：所在学院
	 */
	public String getEducationprofessional() {
		return educationprofessional;
	}
	/**
	 * 设置：证书
	 */
	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}
	/**
	 * 获取：证书
	 */
	public String getCertificates() {
		return certificates;
	}
	/**
	 * 设置：就业记录
	 */
	public void setEmploymentrecord(String employmentrecord) {
		this.employmentrecord = employmentrecord;
	}
	/**
	 * 获取：就业记录
	 */
	public String getEmploymentrecord() {
		return employmentrecord;
	}
	/**
	 * 设置：汉语等级
	 */
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	/**
	 * 获取：汉语等级
	 */
	public String getChinese() {
		return chinese;
	}
	/**
	 * 设置：英语等级
	 */
	public void setEnglish(String english) {
		this.english = english;
	}
	/**
	 * 获取：英语等级
	 */
	public String getEnglish() {
		return english;
	}
	/**
	 * 设置：汉语分数
	 */
	public void setChinesescore(String chinesescore) {
		this.chinesescore = chinesescore;
	}
	/**
	 * 获取：汉语分数
	 */
	public String getChinesescore() {
		return chinesescore;
	}
	/**
	 * 设置：其他语言
	 */
	public void setOtherlanguage(String otherlanguage) {
		this.otherlanguage = otherlanguage;
	}
	/**
	 * 获取：其他语言
	 */
	public String getOtherlanguage() {
		return otherlanguage;
	}
	/**
	 * 设置：是否在中国工作
	 */
	public void setWorkedinchina(String workedinchina) {
		this.workedinchina = workedinchina;
	}
	/**
	 * 获取：是否在中国工作
	 */
	public String getWorkedinchina() {
		return workedinchina;
	}
	/**
	 * 设置：学生类型
	 */
	public void setStudenttype(String studenttype) {
		this.studenttype = studenttype;
	}
	/**
	 * 获取：学生类型
	 */
	public String getStudenttype() {
		return studenttype;
	}
	/**
	 * 设置：综合学校
	 */
	public void setApllyschool(String apllyschool) {
		this.apllyschool = apllyschool;
	}
	/**
	 * 获取：综合学校
	 */
	public String getApllyschool() {
		return apllyschool;
	}
	/**
	 * 设置：专业
	 */
	public void setApllyprofessional(String apllyprofessional) {
		this.apllyprofessional = apllyprofessional;
	}
	/**
	 * 获取：专业
	 */
	public String getApllyprofessional() {
		return apllyprofessional;
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
	 * 设置：毕业计划
	 */
	public void setGraduationplan(String graduationplan) {
		this.graduationplan = graduationplan;
	}
	/**
	 * 获取：毕业计划
	 */
	public String getGraduationplan() {
		return graduationplan;
	}
	/**
	 * 设置：产品
	 */
	public void setProduction(String production) {
		this.production = production;
	}
	/**
	 * 获取：产品
	 */
	public String getProduction() {
		return production;
	}
	/**
	 * 设置：奖学金申请
	 */
	public void setScholarshipapplied(String scholarshipapplied) {
		this.scholarshipapplied = scholarshipapplied;
	}
	/**
	 * 获取：奖学金申请
	 */
	public String getScholarshipapplied() {
		return scholarshipapplied;
	}
	/**
	 * 设置：职业
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * 获取：职业
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * 设置：申请人在华事务联系人或机构名称
	 */
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	/**
	 * 获取：申请人在华事务联系人或机构名称
	 */
	public String getContactname() {
		return contactname;
	}
	/**
	 * 设置：申请人在华事务联系人或机构电话
	 */
	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}
	/**
	 * 获取：申请人在华事务联系人或机构电话
	 */
	public String getContacttel() {
		return contacttel;
	}
	/**
	 * 设置：申请人在华事务联系人或机构传真
	 */
	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}
	/**
	 * 获取：申请人在华事务联系人或机构传真
	 */
	public String getContactfax() {
		return contactfax;
	}
	/**
	 * 设置：申请人在华事务联系人或机构地址
	 */
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	/**
	 * 获取：申请人在华事务联系人或机构地址
	 */
	public String getContactaddress() {
		return contactaddress;
	}
	/**
	 * 设置：申请人在华事务联系人或机构邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：申请人在华事务联系人或机构邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：配偶姓名
	 */
	public void setSpousename(String spousename) {
		this.spousename = spousename;
	}
	/**
	 * 获取：配偶姓名
	 */
	public String getSpousename() {
		return spousename;
	}
	/**
	 * 设置：配偶年龄
	 */
	public void setSpouseage(String spouseage) {
		this.spouseage = spouseage;
	}
	/**
	 * 获取：配偶年龄
	 */
	public String getSpouseage() {
		return spouseage;
	}
	/**
	 * 设置：配偶国籍
	 */
	public void setSpousecountry(String spousecountry) {
		this.spousecountry = spousecountry;
	}
	/**
	 * 获取：配偶国籍
	 */
	public String getSpousecountry() {
		return spousecountry;
	}
	/**
	 * 设置：配偶职业
	 */
	public void setSpouseemployment(String spouseemployment) {
		this.spouseemployment = spouseemployment;
	}
	/**
	 * 获取：配偶职业
	 */
	public String getSpouseemployment() {
		return spouseemployment;
	}
	/**
	 * 设置：配偶受教育程度
	 */
	public void setSpouseeducation(String spouseeducation) {
		this.spouseeducation = spouseeducation;
	}
	/**
	 * 获取：配偶受教育程度
	 */
	public String getSpouseeducation() {
		return spouseeducation;
	}
	/**
	 * 设置：父亲姓名
	 */
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	/**
	 * 获取：父亲姓名
	 */
	public String getFathername() {
		return fathername;
	}
	/**
	 * 设置：父亲年龄
	 */
	public void setFatherage(String fatherage) {
		this.fatherage = fatherage;
	}
	/**
	 * 获取：父亲年龄
	 */
	public String getFatherage() {
		return fatherage;
	}
	/**
	 * 设置：父亲国籍
	 */
	public void setFathercountry(String fathercountry) {
		this.fathercountry = fathercountry;
	}
	/**
	 * 获取：父亲国籍
	 */
	public String getFathercountry() {
		return fathercountry;
	}
	/**
	 * 设置：父亲职业
	 */
	public void setFatheremploymnet(String fatheremploymnet) {
		this.fatheremploymnet = fatheremploymnet;
	}
	/**
	 * 获取：父亲职业
	 */
	public String getFatheremploymnet() {
		return fatheremploymnet;
	}
	/**
	 * 设置：父亲受教育程度
	 */
	public void setFathereducation(String fathereducation) {
		this.fathereducation = fathereducation;
	}
	/**
	 * 获取：父亲受教育程度
	 */
	public String getFathereducation() {
		return fathereducation;
	}
	/**
	 * 设置：母亲姓名
	 */
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	/**
	 * 获取：母亲姓名
	 */
	public String getMothername() {
		return mothername;
	}
	/**
	 * 设置：母亲年龄
	 */
	public void setMotherage(String motherage) {
		this.motherage = motherage;
	}
	/**
	 * 获取：母亲年龄
	 */
	public String getMotherage() {
		return motherage;
	}
	/**
	 * 设置：母亲国籍
	 */
	public void setMothercountry(String mothercountry) {
		this.mothercountry = mothercountry;
	}
	/**
	 * 获取：母亲国籍
	 */
	public String getMothercountry() {
		return mothercountry;
	}
	/**
	 * 设置：母亲职业
	 */
	public void setMotheremployment(String motheremployment) {
		this.motheremployment = motheremployment;
	}
	/**
	 * 获取：母亲职业
	 */
	public String getMotheremployment() {
		return motheremployment;
	}
	/**
	 * 设置：母亲受教育程度
	 */
	public void setMothereducation(String mothereducation) {
		this.mothereducation = mothereducation;
	}
	/**
	 * 获取：母亲受教育程度
	 */
	public String getMothereducation() {
		return mothereducation;
	}
	/**
	 * 设置：推荐院校
	 */
	public void setRecominstitutions(String recominstitutions) {
		this.recominstitutions = recominstitutions;
	}
	/**
	 * 获取：推荐院校
	 */
	public String getRecominstitutions() {
		return recominstitutions;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：奖学金项目
	 */
	public void setProject(String project) {
		this.project = project;
	}
	/**
	 * 获取：奖学金项目
	 */
	public String getProject() {
		return project;
	}
	/**
	 * 设置：奖学金类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：奖学金类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：学生层次
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：学生层次
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：申报专业
	 */
	public void setDecprofession(String decprofession) {
		this.decprofession = decprofession;
	}
	/**
	 * 获取：申报专业
	 */
	public String getDecprofession() {
		return decprofession;
	}
	/**
	 * 设置：奖学金申请照片id
	 */
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	/**
	 * 获取：奖学金申请照片id
	 */
	public String getPhotoid() {
		return photoid;
	}
	/**
	 * 设置：申请人传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：申请人传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：永久通信地址
	 */
	public void setPremanentaddres(String premanentaddres) {
		this.premanentaddres = premanentaddres;
	}
	/**
	 * 获取：永久通信地址
	 */
	public String getPremanentaddres() {
		return premanentaddres;
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
	 * 设置：hsk考试登记或其他类型汉语考试成绩
	 */
	public void setHsk(String hsk) {
		this.hsk = hsk;
	}
	/**
	 * 获取：hsk考试登记或其他类型汉语考试成绩
	 */
	public String getHsk() {
		return hsk;
	}
	/**
	 * 设置：是否可以用英语学习
	 */
	public void setCanstudy(String canstudy) {
		this.canstudy = canstudy;
	}
	/**
	 * 获取：是否可以用英语学习
	 */
	public String getCanstudy() {
		return canstudy;
	}
	/**
	 * 设置：申请来华学习专业
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：申请来华学习专业
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：申请院校
	 */
	public void setEducationchina(String educationchina) {
		this.educationchina = educationchina;
	}
	/**
	 * 获取：申请院校
	 */
	public String getEducationchina() {
		return educationchina;
	}
	/**
	 * 设置：申请专业学习时间起
	 */
	public void setStudystart(String studystart) {
		this.studystart = studystart;
	}
	/**
	 * 获取：申请专业学习时间起
	 */
	public String getStudystart() {
		return studystart;
	}
	/**
	 * 设置：申请专业学习时间终
	 */
	public void setStudyend(String studyend) {
		this.studyend = studyend;
	}
	/**
	 * 获取：申请专业学习时间终
	 */
	public String getStudyend() {
		return studyend;
	}
	/**
	 * 设置：是否需要补习汉语
	 */
	public void setNeedstudychinese(String needstudychinese) {
		this.needstudychinese = needstudychinese;
	}
	/**
	 * 获取：是否需要补习汉语
	 */
	public String getNeedstudychinese() {
		return needstudychinese;
	}
	/**
	 * 设置：是否需要补习汉语的补习时间(是的答案)
	 */
	public void setNeedstudychinesetime(String needstudychinesetime) {
		this.needstudychinesetime = needstudychinesetime;
	}
	/**
	 * 获取：是否需要补习汉语的补习时间(是的答案)
	 */
	public String getNeedstudychinesetime() {
		return needstudychinesetime;
	}
	/**
	 * 设置：其他的(否的答案)
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 获取：其他的(否的答案)
	 */
	public String getOther() {
		return other;
	}
	/**
	 * 设置：拟在华学习或研究的详细内容
	 */
	public void setOtherplan(String otherplan) {
		this.otherplan = otherplan;
	}
	/**
	 * 获取：拟在华学习或研究的详细内容
	 */
	public String getOtherplan() {
		return otherplan;
	}
	/**
	 * 设置：曾发表的主要学术论文、著作及作品
	 */
	public void setOtherpublished(String otherpublished) {
		this.otherpublished = otherpublished;
	}
	/**
	 * 获取：曾发表的主要学术论文、著作及作品
	 */
	public String getOtherpublished() {
		return otherpublished;
	}
	/**
	 * 设置：推荐您申请天津市政府奖学金的机构或个人
	 */
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}
	/**
	 * 获取：推荐您申请天津市政府奖学金的机构或个人
	 */
	public String getScholarship() {
		return scholarship;
	}
	/**
	 * 设置：申请人是否曾在华学习和任职
	 */
	public void setStudiedorwork(String studiedorwork) {
		this.studiedorwork = studiedorwork;
	}
	/**
	 * 获取：申请人是否曾在华学习和任职
	 */
	public String getStudiedorwork() {
		return studiedorwork;
	}
	/**
	 * 设置：学习或任职单位
	 */
	public void setInstitutionoremployer(String institutionoremployer) {
		this.institutionoremployer = institutionoremployer;
	}
	/**
	 * 获取：学习或任职单位
	 */
	public String getInstitutionoremployer() {
		return institutionoremployer;
	}
	/**
	 * 设置：在华起止时间
	 */
	public void setStarttimechina(String starttimechina) {
		this.starttimechina = starttimechina;
	}
	/**
	 * 获取：在华起止时间
	 */
	public String getStarttimechina() {
		return starttimechina;
	}
	/**
	 * 设置：在华终止时间
	 */
	public void setEndtimechina(String endtimechina) {
		this.endtimechina = endtimechina;
	}
	/**
	 * 获取：在华终止时间
	 */
	public String getEndtimechina() {
		return endtimechina;
	}
	/**
	 * 设置：推荐信1
	 */
	public void setRecom1(String recom1) {
		this.recom1 = recom1;
	}
	/**
	 * 获取：推荐信1
	 */
	public String getRecom1() {
		return recom1;
	}
	/**
	 * 设置：推荐信2
	 */
	public void setRecom2(String recom2) {
		this.recom2 = recom2;
	}
	/**
	 * 获取：推荐信2
	 */
	public String getRecom2() {
		return recom2;
	}
	/**
	 * 设置：有关中国院校接受函或录取通知书
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}
	/**
	 * 获取：有关中国院校接受函或录取通知书
	 */
	public String getNotice() {
		return notice;
	}
	/**
	 * 设置：本人最后学历成绩单复印件（须公证）
	 */
	public void setSchoolreport(String schoolreport) {
		this.schoolreport = schoolreport;
	}
	/**
	 * 获取：本人最后学历成绩单复印件（须公证）
	 */
	public String getSchoolreport() {
		return schoolreport;
	}
	/**
	 * 设置：本人最后学历证书复印件（须公证）
	 */
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	/**
	 * 获取：本人最后学历证书复印件（须公证）
	 */
	public String getDiploma() {
		return diploma;
	}
	/**
	 * 设置：（本科/，硕士，博士，其它）
	 */
	public void setDiplomatype(String diplomatype) {
		this.diplomatype = diplomatype;
	}
	/**
	 * 获取：（本科/，硕士，博士，其它）
	 */
	public String getDiplomatype() {
		return diplomatype;
	}
	/**
	 * 设置：外国人体格检查记录
	 */
	public void setExamination(String examination) {
		this.examination = examination;
	}
	/**
	 * 获取：外国人体格检查记录
	 */
	public String getExamination() {
		return examination;
	}
	/**
	 * 设置：来华学习计划
	 */
	public void setPlanchina(String planchina) {
		this.planchina = planchina;
	}
	/**
	 * 获取：来华学习计划
	 */
	public String getPlanchina() {
		return planchina;
	}
	/**
	 * 设置：所发表的文章等
	 */
	public void setArticle(String article) {
		this.article = article;
	}
	/**
	 * 获取：所发表的文章等
	 */
	public String getArticle() {
		return article;
	}
	/**
	 * 设置：其他附件
	 */
	public void setOtherannex(String otherannex) {
		this.otherannex = otherannex;
	}
	/**
	 * 获取：其他附件
	 */
	public String getOtherannex() {
		return otherannex;
	}
	/**
	 * 设置：类型
	 */
	public void setScholarshiptype(Integer scholarshiptype) {
		this.scholarshiptype = scholarshiptype;
	}
	/**
	 * 获取：类型
	 */
	public Integer getScholarshiptype() {
		return scholarshiptype;
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
     * 获取：性别
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：婚姻
     */
    public String getMarriage() {
        return marriage;
    }
    /**
     * 设置：婚姻
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }
    /**
     * 获取：出生国
     */
    public String getBirthcountry() {
        return birthcountry;
    }
    /**
     * 设置：出生国
     */
    public void setBirthcountry(String birthcountry) {
        this.birthcountry = birthcountry;
    }
}
