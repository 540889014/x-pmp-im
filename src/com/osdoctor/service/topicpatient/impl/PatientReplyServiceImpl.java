package com.osdoctor.service.topicpatient.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topicpatient.PatientReplyDao;
import com.osdoctor.orm.topicpatient.PatientReply;
import com.osdoctor.service.topicpatient.PatientReplyService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class PatientReplyServiceImpl extends BaseServiceImpl<PatientReply> implements PatientReplyService{

	private PatientReplyDao patientReplyDao;
	@Resource
	public void setPatientReplyDao(PatientReplyDao patientReplyDao) {
		super.setBaseDao(patientReplyDao);
		this.patientReplyDao = patientReplyDao;
	}
}
