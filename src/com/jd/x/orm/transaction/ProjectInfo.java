package com.jd.x.orm.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jd.x.orm.common.UserInfo;


public class ProjectInfo {

	private Long id;
	private String projectName;
	private Date startTime;
	private Date endTime;
	private String type;
	private Integer state;
	private UserInfo userInfo;//负责人，可以分配项目成员
	private List<ProjectMember> projectMembers = new ArrayList<ProjectMember>();//项目成员
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<ProjectMember> getProjectMembers() {
		return projectMembers;
	}
	public void setProjectMembers(List<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
