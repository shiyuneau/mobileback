package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 工作经历表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-05 22:42:10
 */
public class WorkexpireEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 学生
	 */
	private String studentguid;
	/**
	 * 留学ID
	 */
	private String studyabroadguid;
	/**
	 * 奖学金
	 */
	private String scholarshipguid;
	/**
	 * 开始时间
	 */
	private String workfrom;
	/**
	 * 结束时间
	 */
	private String workto;
	/**
	 * 单位名称
	 */
	private String workcompany;
	/**
	 * 职务
	 */
	private String workposition;

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
	 * 设置：学生
	 */
	public void setStudentguid(String studentguid) {
		this.studentguid = studentguid;
	}
	/**
	 * 获取：学生
	 */
	public String getStudentguid() {
		return studentguid;
	}
	/**
	 * 设置：留学ID
	 */
	public void setStudyabroadguid(String studyabroadguid) {
		this.studyabroadguid = studyabroadguid;
	}
	/**
	 * 获取：留学ID
	 */
	public String getStudyabroadguid() {
		return studyabroadguid;
	}
	/**
	 * 设置：奖学金
	 */
	public void setScholarshipguid(String scholarshipguid) {
		this.scholarshipguid = scholarshipguid;
	}
	/**
	 * 获取：奖学金
	 */
	public String getScholarshipguid() {
		return scholarshipguid;
	}
	/**
	 * 设置：开始时间
	 */
	public void setWorkfrom(String workfrom) {
		this.workfrom = workfrom;
	}
	/**
	 * 获取：开始时间
	 */
	public String getWorkfrom() {
		return workfrom;
	}
	/**
	 * 设置：结束时间
	 */
	public void setWorkto(String workto) {
		this.workto = workto;
	}
	/**
	 * 获取：结束时间
	 */
	public String getWorkto() {
		return workto;
	}
	/**
	 * 设置：单位名称
	 */
	public void setWorkcompany(String workcompany) {
		this.workcompany = workcompany;
	}
	/**
	 * 获取：单位名称
	 */
	public String getWorkcompany() {
		return workcompany;
	}
	/**
	 * 设置：职务
	 */
	public void setWorkposition(String workposition) {
		this.workposition = workposition;
	}
	/**
	 * 获取：职务
	 */
	public String getWorkposition() {
		return workposition;
	}
}
