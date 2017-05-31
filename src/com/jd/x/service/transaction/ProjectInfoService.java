package com.jd.x.service.transaction;

import java.util.List;

import com.jd.x.orm.common.UserInfo;
import com.jd.x.orm.transaction.ProjectInfo;
import com.jd.x.util.BaseService;

public interface ProjectInfoService extends BaseService<ProjectInfo>{

	
	public List<ProjectInfo> queryProjectByUser(UserInfo userInfo, Integer pageNum, Integer pageSize);
}
