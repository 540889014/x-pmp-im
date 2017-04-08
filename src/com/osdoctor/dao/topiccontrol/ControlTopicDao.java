package com.osdoctor.dao.topiccontrol;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topiccontrol.ControlTopic;
import com.osdoctor.util.BaseDao;

public interface ControlTopicDao extends BaseDao<ControlTopic>{

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
