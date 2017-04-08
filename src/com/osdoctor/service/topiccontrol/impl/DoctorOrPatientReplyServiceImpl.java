package com.osdoctor.service.topiccontrol.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topiccontrol.ControlTopicDao;
import com.osdoctor.dao.topiccontrol.DoctorOrPatientReplyDao;
import com.osdoctor.orm.topiccontrol.DoctorOrPatientReply;
import com.osdoctor.service.topiccontrol.DoctorOrPatientReplyService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class DoctorOrPatientReplyServiceImpl extends BaseServiceImpl<DoctorOrPatientReply> implements DoctorOrPatientReplyService{

	private DoctorOrPatientReplyDao doctorOrPatientReplyDao;
	@Resource
	public void setDoctorOrPatientReplyDao(DoctorOrPatientReplyDao doctorOrPatientReplyDao) {
		super.setBaseDao(doctorOrPatientReplyDao);
		this.doctorOrPatientReplyDao = doctorOrPatientReplyDao;
	}
}
