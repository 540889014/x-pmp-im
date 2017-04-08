package com.osdoctor.action.osOperaor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.osOperaor.OsPatient;

public class OsPatientAction extends BaseAction<OsPatient>{

	
	public String login()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("psw");
		patients=osPatientService.login(username, password);
		
		//解决跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "login";
	}
	public String findByHot()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		osPatients=osPatientService.findByHot(num, size);
		//解决跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findByHot";
	}
	//-------------------------------------------------------------------------------------------------------------------
	//患者信息
	List<OsPatient> patients=new ArrayList<OsPatient>();
	List<Map<Object, Object>> osPatients = new ArrayList<Map<Object,Object>>();

	public List<OsPatient> getPatients() {
		return patients;
	}

	public void setPatients(List<OsPatient> patients) {
		this.patients = patients;
	}

	public List<Map<Object, Object>> getOsPatients() {
		return osPatients;
	}

	public void setOsPatients(List<Map<Object, Object>> osPatients) {
		this.osPatients = osPatients;
	}
	
}
