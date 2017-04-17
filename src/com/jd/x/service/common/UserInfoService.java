package com.jd.x.service.common;

import com.jd.x.orm.common.UserInfo;
import com.jd.x.util.BaseService;

public interface UserInfoService extends BaseService<UserInfo>{

	
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	UserInfo login(UserInfo userInfo);
}
