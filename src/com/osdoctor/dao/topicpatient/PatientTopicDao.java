package com.osdoctor.dao.topicpatient;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topicpatient.PatientTopic;
import com.osdoctor.util.BaseDao;

public interface PatientTopicDao extends BaseDao<PatientTopic>{

	/**
	 * 获取热门帖子
	 * @param pagenum 当前页
	 * @param pagesize获取的帖子数量
	 * @return
	 */
	public List<Map<Object, Object>> findByCountHot(int pagenum,int pagesize);
	
	/**
	 * 获取活跃用户
	 * @param num当前页
	 * @param size获取数量
	 * @return
	 */
	public List<Map<Object, Object>> findUserByHot(int num,int size);
	
	/**
	 * 获取最新帖子
	 * @param num当前页
	 * @param size获取数量
	 * @return
	 */
	public List<Map<Object, Object>> findNewTopic(int num,int size);
}
