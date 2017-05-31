package com.jd.x.dao.transaction.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jd.x.dao.transaction.ProjectInfoDao;
import com.jd.x.orm.common.UserInfo;
import com.jd.x.orm.transaction.ProjectInfo;
import com.jd.x.util.BaseDaoImpl;

@Repository
public class ProjectInfoDaoImpl extends BaseDaoImpl<ProjectInfo> implements ProjectInfoDao{

	
	public List<ProjectInfo> queryProjectByUser(UserInfo userInfo, Integer pageNum, Integer pageSize){
		return getSession().createQuery("FROM ProjectInfo where userInfo = ? ").setEntity(0, userInfo).list();
	}
}
