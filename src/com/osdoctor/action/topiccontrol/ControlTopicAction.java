package com.osdoctor.action.topiccontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.topiccontrol.ControlTopic;

public class ControlTopicAction extends BaseAction<ControlTopic>{

	/**
	 * 获取最新资讯
	 * @return
	 */
	public String findNewTopic()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		controlTopics=controlTopicService.findNewTopic(num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findNewTopic";
	}
	/**
	 * 获取热门资讯
	 * @return
	 */
	public String findHotTopic()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		controlTopics=controlTopicService.findHotTopic(num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findHotTopic";
	}
	/**
	 * 获取某版块资讯
	 * @return
	 */
	public String findTopicBySection()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		String sectionId=request.getParameter("section");
		controlTopics=controlTopicService.findTopicBySection(sectionId, num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findHotTopic";
	}
	//------------------------------------------------------------------------
	
	private List<Map<Object, Object>> controlTopics = new ArrayList<Map<Object,Object>>();

	public List<Map<Object, Object>> getControlTopics() {
		return controlTopics;
	}

	public void setControlTopics(List<Map<Object, Object>> controlTopics) {
		this.controlTopics = controlTopics;
	}
	
}
