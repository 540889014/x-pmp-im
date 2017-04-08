package com.osdoctor.service.topiccommon.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineDayRecommendDao;
import com.osdoctor.dao.topiccommon.TopicLabelDao;
import com.osdoctor.orm.topicCommon.TopicLabel;
import com.osdoctor.service.topiccommon.TopicLabelService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class TopicLabelServiceImpl extends BaseServiceImpl<TopicLabel> implements TopicLabelService{

	private TopicLabelDao topicLabelDao;
	@Resource
	public void setTopicLabelDao(TopicLabelDao topicLabelDao) {
		super.setBaseDao(topicLabelDao);
		this.topicLabelDao = topicLabelDao;
	}
	public List<Map<Object, Object>> findByHot(String type) {
		return topicLabelDao.findByHot(type);
	}
	public List<Map<Object, Object>> findHotByUser(String type,String userId, int num,
			int size) {
		return topicLabelDao.findHotByUser(type,userId, num, size);
	}
}
