package com.osdoctor.service.topicdoctormine.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.osOperaor.OsControlDao;
import com.osdoctor.dao.topicdoctormine.PatientMineReplyDao;
import com.osdoctor.orm.topicdoctormine.PatientMineReply;
import com.osdoctor.service.topicdoctormine.PatientMineReplyService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class PatientMineReplyServiceImpl extends BaseServiceImpl<PatientMineReply> implements PatientMineReplyService{

	private PatientMineReplyDao patientMineReplyDao;
	@Resource
	public void setPatientMineReplyDao(PatientMineReplyDao patientMineReplyDao) {
		super.setBaseDao(patientMineReplyDao);
		this.patientMineReplyDao = patientMineReplyDao;
	}
}
