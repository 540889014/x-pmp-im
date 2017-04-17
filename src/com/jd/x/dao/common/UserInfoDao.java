package com.jd.x.dao.common;

import com.jd.x.orm.common.UserInfo;
import com.jd.x.util.BaseDao;

public interface UserInfoDao extends BaseDao<UserInfo>{
	
	
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	UserInfo login(UserInfo userInfo);

}
