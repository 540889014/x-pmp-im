package com.osdoctor.action.topiccontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.topiccontrol.ControlSection;

public class ControlSectionAction extends BaseAction<ControlSection>{
	
	
	public String findAllSection()
	{
		sections=controlSectionService.findAllSection();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findAllSection";
	}
	
	//----------------------------------------------------------------------------
	List<Map<Object, Object>> sections = new ArrayList<Map<Object,Object>>();

	public List<Map<Object, Object>> getSections() {
		return sections;
	}

	public void setSections(List<Map<Object, Object>> sections) {
		this.sections = sections;
	}
	

}
