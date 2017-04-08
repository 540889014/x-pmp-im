package com.osdoctor.action.topiccommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.topicCommon.TopicLabel;

public class TopicLabelAction extends BaseAction<TopicLabel>{

	
	/**
	 * 获取热门话题
	 * @return
	 */
	public String findByHot()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String type=request.getParameter("type");
		hotLabels=topicLabelService.findByHot(type);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "hotlabel";
	}
	
	/**
	 * 获取所有热门话题并根据用户判断是否被用户关注
	 * @return
	 */
	public String findHotByUser()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String type=request.getParameter("type");
		String userId=request.getParameter("userId");
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		hotLabels=topicLabelService.findHotByUser(type,userId, num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findHotByUser";
	}
	
	//---------------------------------------------------------------------------------------
	List<Map<Object, Object>> hotLabels=new ArrayList<Map<Object,Object>>();

	public List<Map<Object, Object>> getHotLabels() {
		return hotLabels;
	}

	public void setHotLabels(List<Map<Object, Object>> hotLabels) {
		this.hotLabels = hotLabels;
	}
	
}
