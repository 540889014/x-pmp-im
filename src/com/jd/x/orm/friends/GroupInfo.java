package com.jd.x.orm.friends;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jd.x.orm.common.UserInfo;

public class GroupInfo {

	private Integer id;
	private String name;//分组名称
	private UserInfo userInfo;//谁的分组
	
	private Set<FriendsInfo> friendsInfos = new HashSet<FriendsInfo>();//分组下的好友

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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Set<FriendsInfo> getFriendsInfos() {
		return friendsInfos;
	}

	public void setFriendsInfos(Set<FriendsInfo> friendsInfos) {
		this.friendsInfos = friendsInfos;
	}
	
}
