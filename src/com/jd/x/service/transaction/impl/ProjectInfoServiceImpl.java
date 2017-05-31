package com.jd.x.service.transaction.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.x.dao.common.UserInfoDao;
import com.jd.x.dao.transaction.ProjectInfoDao;
import com.jd.x.orm.common.UserInfo;
import com.jd.x.orm.transaction.ProjectInfo;
import com.jd.x.service.transaction.ProjectInfoService;
import com.jd.x.util.BaseServiceImpl;
@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfo> implements ProjectInfoService{

	private ProjectInfoDao projectInfoDao;

	@Resource
	public void setProjectInfoDao(ProjectInfoDao projectInfoDao) {
		super.setBaseDao(projectInfoDao);
		this.projectInfoDao = projectInfoDao;
	}
	public List<ProjectInfo> queryProjectByUser(UserInfo userInfo, Integer pageNum, Integer pageSize){
		
		return projectInfoDao.queryProjectByUser(userInfo, pageNum, pageSize);
	}
}
