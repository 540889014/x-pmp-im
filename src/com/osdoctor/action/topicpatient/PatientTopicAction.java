package com.osdoctor.action.topicpatient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.topicpatient.PatientTopic;
/**
 * 帖子
 * @author admin
 *
 */
public class PatientTopicAction extends BaseAction<PatientTopic>{

	/**
	 * 获取最新帖子
	 * @return
	 */
	public String findByTime()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		patientTopics=patientTopicService.findNewTopic(num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findByTime";
		
	}
	/**
	 * 获取热门帖子
	 * @return
	 */
	public String findByHot() 
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int num=Integer.parseInt(request.getParameter("num")==null?"0":request.getParameter("num"));
		int size=Integer.parseInt(request.getParameter("size")==null?"10":request.getParameter("size"));
		patientTopics=patientTopicService.findByCountHot(num, size);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "findByHot";
	}
	
	//-------------------------------------------------------------------------------
	
	private List<Map<Object, Object>> patientTopics = new ArrayList<Map<Object,Object>>();

	public List<Map<Object, Object>> getPatientTopics() {
		return patientTopics;
	}

	public void setPatientTopics(List<Map<Object, Object>> patientTopics) {
		this.patientTopics = patientTopics;
	}

}
