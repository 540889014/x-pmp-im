package com.jd.x.dao.transaction;

import java.util.List;

import com.jd.x.orm.common.UserInfo;
import com.jd.x.orm.transaction.ProjectInfo;
import com.jd.x.util.BaseDao;

public interface ProjectInfoDao extends BaseDao<ProjectInfo>{

	
	List<ProjectInfo> queryProjectByUser(UserInfo userInfo, Integer pageNum, Integer pageSize);
}
