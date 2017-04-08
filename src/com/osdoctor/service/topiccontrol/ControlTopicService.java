package com.osdoctor.service.topiccontrol;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topiccontrol.ControlTopic;
import com.osdoctor.util.BaseService;

public interface ControlTopicService extends BaseService<ControlTopic>{

	/**
	 * 获取最新资讯
	 * @param num当前页
	 * @param size获取选手
	 * @return
	 */
	List<Map<Object, Object>> findNewTopic(int num,int size);
	
	/**
	 * 获取热门资讯
	 * @param num当前页
	 * @param size获取选手
	 * @return
	 */
	List<Map<Object, Object>> findHotTopic(int num,int size);
	
	/**
	 * 获取某版块资讯
	 * @param num当前页
	 * @param size获取选手
	 * @return
	 */
	List<Map<Object, Object>> findTopicBySection(String sectionId,int num,int size);
}
