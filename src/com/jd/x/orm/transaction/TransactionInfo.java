package com.jd.x.orm.transaction;

import java.util.Date;

import com.jd.x.orm.common.UserInfo;

public class TransactionInfo {

	private Integer id;
	private String name;//事务名称
	private Date start;//开始时间
	private Date end;//结束时间
	private String detail;//事务详细
	private String duty;//职责
	private String summary;//总结
	private UserInfo userInfo;//谁的事务
	private ProjectInfo projectInfo;//所属项目 

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
}
