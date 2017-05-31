package com.jd.x.orm.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jd.x.orm.friends.FriendsInfo;
import com.jd.x.orm.friends.GroupInfo;
import com.jd.x.orm.transaction.ProjectInfo;
import com.jd.x.orm.transaction.ProjectMember;

public class UserInfo {

	private Integer id;
	private String pin;//用户pin ， 
	private String psw;//密码
	private String nickName;//昵称 
	private Integer sex;//性别1男，2女
	private String sign;//签名
	private Set<ProjectMember> projectMembers = new HashSet<ProjectMember>();//参与的项目
	private Set<GroupInfo> groupInfos = new HashSet<GroupInfo>();//我的好友
	
	public String getPin() {
		return pin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Set<ProjectMember> getProjectMembers() {
		return projectMembers;
	}
	public void setProjectMembers(Set<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}
	public Set<GroupInfo> getGroupInfos() {
		return groupInfos;
	}
	public void setGroupInfos(Set<GroupInfo> groupInfos) {
		this.groupInfos = groupInfos;
	}

}
