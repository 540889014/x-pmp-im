package com.jd.x.dao.common.impl;

import org.springframework.stereotype.Repository;

import com.jd.x.dao.common.UserInfoDao;
import com.jd.x.orm.common.UserInfo;
import com.jd.x.util.BaseDaoImpl;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao{

	public UserInfo login(UserInfo userInfo) {
		return (UserInfo)getSession().createQuery("from UserInfo where pin = ? and psw = ?").setString(0, userInfo.getPin()).setString(1, userInfo.getPsw()).uniqueResult();
	}

	public UserInfo getByPin(String pin) {
		return (UserInfo)getSession().createQuery("from UserInfo where pin = ?").setString(0, pin).uniqueResult();
	}
}
