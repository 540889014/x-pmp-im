package com.osdoctor.dao.topiccommon;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topicCommon.TopicLabel;
import com.osdoctor.util.BaseDao;

public interface TopicLabelDao extends BaseDao<TopicLabel>{

	/**
	 * 
	 * 获取热门话题
	 * @return
	 */
	public List<Map<Object, Object>> findByHot(String type);
	
	/**
	 * 
	 * 根据用户获取热门话题
	 * @return
	 */
	public List<Map<Object, Object>> findHotByUser(String type,String userId, int num, int size);
	
	
}
