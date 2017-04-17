package com.jd.x.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jd.x.action.BaseAction;
import com.jd.x.orm.common.UserInfo;

@Controller
public class UserInfoAction extends BaseAction<UserInfo>{
	
	private UserInfo userInfo;
	
	public String login(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String pin=request.getParameter("pin");
		String psw = request.getParameter("psw");
		UserInfo userInfoParma = new UserInfo();
		userInfoParma.setPin(pin);
		userInfoParma.setPsw(psw);
		userInfo= userInfoService.login(userInfoParma);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "success";
	}
	
	public String reg(){
		HttpServletRequest request=ServletActionContext.getRequest();
		userInfoService.save(getModel());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "success";
	}
	
	public String queryById(){
		HttpServletRequest request=ServletActionContext.getRequest();
		userInfo = userInfoService.getById(getModel().getId());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "success";
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
