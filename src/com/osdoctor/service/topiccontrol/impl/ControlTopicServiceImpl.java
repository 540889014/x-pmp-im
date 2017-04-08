package com.osdoctor.service.topiccontrol.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topiccontrol.ControlTopicDao;
import com.osdoctor.dao.topiccontrol.ControlTopicPhotoDao;
import com.osdoctor.orm.topiccontrol.ControlTopic;
import com.osdoctor.service.topiccontrol.ControlTopicService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class ControlTopicServiceImpl extends BaseServiceImpl<ControlTopic> implements ControlTopicService{

	private ControlTopicDao controlTopicDao;
	@Resource
	public void setControlTopicDao(ControlTopicDao controlTopicDao) {
		super.setBaseDao(controlTopicDao);
		this.controlTopicDao = controlTopicDao;
	}
	public List<Map<Object, Object>> findNewTopic(int num, int size) {
		// TODO Auto-generated method stub
		return controlTopicDao.findNewTopic(num, size);
	}
	public List<Map<Object, Object>> findHotTopic(int num, int size) {
		// TODO Auto-generated method stub
		return controlTopicDao.findHotTopic(num, size);
	}
	public List<Map<Object, Object>> findTopicBySection(String sectionId,
			int num, int size) {
		// TODO Auto-generated method stub
		return controlTopicDao.findTopicBySection(sectionId, num, size);
	}
}
