package com.osdoctor.service.topiccontrol.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topiccommon.TopicLabelDao;
import com.osdoctor.dao.topiccontrol.ControlSectionDao;
import com.osdoctor.orm.topiccontrol.ControlSection;
import com.osdoctor.service.topiccontrol.ControlSectionService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class ControlSectionServiceImpl extends BaseServiceImpl<ControlSection> implements ControlSectionService{

	private ControlSectionDao controlSectionDao;
	@Resource
	public void setControlSectionDao(ControlSectionDao controlSectionDao) {
		super.setBaseDao(controlSectionDao);
		this.controlSectionDao = controlSectionDao;
	}
	public List<Map<Object, Object>> findAllSection() {
		// TODO Auto-generated method stub
		return controlSectionDao.findAllSection();
	}
}
