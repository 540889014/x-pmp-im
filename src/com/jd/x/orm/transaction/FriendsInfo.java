package com.jd.x.orm.transaction;

import java.util.List;

import com.osdoctor.orm.common.UserInfo;

public class FriendsInfo {

	private UserInfo userInfo;
	private List<UserInfo> myFriends;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<UserInfo> getMyFriends() {
		return myFriends;
	}
	public void setMyFriends(List<UserInfo> myFriends) {
		this.myFriends = myFriends;
	}
	
}
