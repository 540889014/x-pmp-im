package com.osdoctor.service.topiccontrol.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topiccommon.TopicLabelDao;
import com.osdoctor.dao.topiccontrol.ControlTopicPhotoDao;
import com.osdoctor.orm.topiccontrol.ControlTopicPhoto;
import com.osdoctor.service.topiccontrol.ControlTopicPhotoService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class ControlTopicPhotoServiceImpl extends BaseServiceImpl<ControlTopicPhoto> implements ControlTopicPhotoService{

	private ControlTopicPhotoDao controlTopicPhotoDao;
	@Resource
	public void setControlTopicPhotoDao(ControlTopicPhotoDao controlTopicPhotoDao) {
		super.setBaseDao(controlTopicPhotoDao);
		this.controlTopicPhotoDao = controlTopicPhotoDao;
	}
}
