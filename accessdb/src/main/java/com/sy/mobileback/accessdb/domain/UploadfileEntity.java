package com.sy.mobileback.accessdb.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-06 11:15:11
 */
public class UploadfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private String guid;
	/**
	 * 对应的学生ID 
	 */
	private String studentguid;
	/**
	 * 文件路径
	 */
	private String filepath;
	/**
	 * 文件源名称
	 */
	private String originfilename;
	/**
	 * 文件用作的途径 1:留学申请，2:奖学金申请，3:其他
	 */
	private Integer type;
	/**
	 * 插入时间
	 */
	private Date inserttime;
	/**
	 * 是否删除，包括上传后又取消 0:未删除，1:已删除
	 */
	private Integer deleted;

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
	 * 设置：对应的学生ID 
	 */
	public void setStudentguid(String studentguid) {
		this.studentguid = studentguid;
	}
	/**
	 * 获取：对应的学生ID 
	 */
	public String getStudentguid() {
		return studentguid;
	}
	/**
	 * 设置：文件路径
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * 设置：文件源名称
	 */
	public void setOriginfilename(String originfilename) {
		this.originfilename = originfilename;
	}
	/**
	 * 获取：文件源名称
	 */
	public String getOriginfilename() {
		return originfilename;
	}
	/**
	 * 设置：文件用作的途径 1:留学申请，2:奖学金申请，3:其他
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：文件用作的途径 1:留学申请，2:奖学金申请，3:其他
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：插入时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：插入时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
	/**
	 * 设置：是否删除，包括上传后又取消 0:未删除，1:已删除
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：是否删除，包括上传后又取消 0:未删除，1:已删除
	 */
	public Integer getDeleted() {
		return deleted;
	}
}
