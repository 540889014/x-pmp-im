package com.jd.x.orm.friends;


import com.jd.x.orm.common.UserInfo;


public class FriendsInfo {

	private Integer id;
	private String remark;
	private GroupInfo groupInfo;//分组信息
	private UserInfo userInfo;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public GroupInfo getGroupInfo() {
		return groupInfo;
	}
	public void setGroupInfo(GroupInfo groupInfo) {
		this.groupInfo = groupInfo;
	}
	
}
