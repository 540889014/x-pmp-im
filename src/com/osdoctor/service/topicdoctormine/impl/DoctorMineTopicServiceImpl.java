package com.osdoctor.service.topicdoctormine.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.osOperaor.OsControlDao;
import com.osdoctor.dao.topicdoctormine.DoctorMineTopicDao;
import com.osdoctor.orm.topicdoctormine.DoctorMineTopic;
import com.osdoctor.service.topicdoctormine.DoctorMineTopicService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class DoctorMineTopicServiceImpl extends BaseServiceImpl<DoctorMineTopic> implements DoctorMineTopicService{

	private DoctorMineTopicDao doctorMineTopicDao;
	@Resource
	public void setDoctorMineTopicDao(DoctorMineTopicDao doctorMineTopicDao) {
		super.setBaseDao(doctorMineTopicDao);
		this.doctorMineTopicDao = doctorMineTopicDao;
	}
}
