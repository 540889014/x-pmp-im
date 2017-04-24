package com.jd.x.orm.friends;

import java.util.List;

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
	
}
