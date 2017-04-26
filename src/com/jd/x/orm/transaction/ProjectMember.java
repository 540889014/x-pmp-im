package com.jd.x.orm.transaction;

import com.jd.x.orm.common.UserInfo;


public class ProjectMember {

	private Integer id;
	private UserInfo userInfo;
	private String dutyName;//职责
	private ProjectInfo projectInfo;
	private String dutyDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	public String getDutyDetail() {
		return dutyDetail;
	}
	public void setDutyDetail(String dutyDetail) {
		this.dutyDetail = dutyDetail;
	}
	
}
