package com.osdoctor.service.topicpatient.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.topicpatient.PatientReplyDao;
import com.osdoctor.dao.topicpatient.PatientSectionDao;
import com.osdoctor.orm.topicpatient.PatientSection;
import com.osdoctor.service.topicpatient.PatientSectionService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class PatientSectionServiceImpl extends BaseServiceImpl<PatientSection> implements PatientSectionService{

	private PatientSectionDao patientSectionDao;
	@Resource
	public void setPatientSectionDao(PatientSectionDao patientSectionDao) {
		super.setBaseDao(patientSectionDao);
		this.patientSectionDao = patientSectionDao;
	}
}
