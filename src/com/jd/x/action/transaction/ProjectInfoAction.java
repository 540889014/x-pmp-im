package com.jd.x.action.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jd.x.action.BaseAction;
import com.jd.x.orm.common.UserInfo;
import com.jd.x.orm.transaction.ProjectInfo;

public class ProjectInfoAction extends BaseAction<ProjectInfo>{

	
	List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
	ProjectInfo projectInfo ;
	
	public String queryProjectByPin(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String pin=request.getParameter("pin");
		UserInfo userInfo = userInfoService.getByPin(pin);
		projectInfos = projectInfoService.queryProjectByUser(userInfo, 0, 100);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "queryProjectByPin";
		
	}
	public String queryProjectById(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		projectInfo = projectInfoService.getById(Integer.parseInt(id.trim()));
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "queryProjectById";
		
	}
	
	public String save(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("userId");
		if(id == null){
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/json; charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
			response.setHeader("Cache-Control", "no-cache");
			return "success";
		}
		UserInfo userInfo = userInfoService.getById(Integer.parseInt(id));
		getModel().setUserInfo(userInfo);
		projectInfoService.save(getModel());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "success";
		
	}

	public List<ProjectInfo> getProjectInfos() {
		return projectInfos;
	}

	public void setProjectInfos(List<ProjectInfo> projectInfos) {
		this.projectInfos = projectInfos;
	}
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
}
