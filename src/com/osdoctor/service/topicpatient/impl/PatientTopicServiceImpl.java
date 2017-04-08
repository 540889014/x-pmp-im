package com.osdoctor.service.topicpatient.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.osOperaor.OsPatientDao;
import com.osdoctor.dao.topicpatient.PatientTopicDao;
import com.osdoctor.orm.topicpatient.PatientTopic;
import com.osdoctor.service.topicpatient.PatientTopicService;
import com.osdoctor.util.BaseServiceImpl;

@Service
public class PatientTopicServiceImpl extends BaseServiceImpl<PatientTopic> implements PatientTopicService{

	
	private PatientTopicDao patientTopicDao;
	@Resource
	public void setPatientTopicDao(PatientTopicDao patientTopicDao) {
		super.setBaseDao(patientTopicDao);
		this.patientTopicDao = patientTopicDao;
	}
	public List<Map<Object, Object>> findByCountHot(int pagenum, int pagesize) {
		return patientTopicDao.findByCountHot(pagenum, pagesize);
	}
	public List<Map<Object, Object>> findUserByHot(int num, int size) {
		return patientTopicDao.findUserByHot(num, size);
	}
	public List<Map<Object, Object>> findNewTopic(int num, int size) {
		return patientTopicDao.findNewTopic(num, size);
	}
}
