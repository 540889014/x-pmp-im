package com.jd.x.orm.friends;

import java.util.ArrayList;
import java.util.List;

import com.jd.x.orm.common.UserInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GroupInfo {

	private Integer id;
	private String name;
	private UserInfo userInfo;
	
	private List<FriendsInfo> friendsInfos = new ArrayList<FriendsInfo>();
	
}
