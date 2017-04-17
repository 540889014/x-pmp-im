package com.jd.x.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.x.dao.common.UserInfoDao;
import com.jd.x.orm.common.UserInfo;
import com.jd.x.service.common.UserInfoService;
import com.jd.x.util.BaseServiceImpl;
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{
	
	private UserInfoDao userInfoDao;

	@Resource
	public void setRoleDao(UserInfoDao userInfoDao) {
		super.setBaseDao(userInfoDao);
		this.userInfoDao = userInfoDao;
	}
	public UserInfo login(UserInfo userInfo) {
		return userInfoDao.login(userInfo);
	}

}
