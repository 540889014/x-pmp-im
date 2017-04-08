package com.osdoctor.service.osOperaor.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.osOperaor.OsPatientDao;
import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.service.osOperaor.OsPatientService;
import com.osdoctor.util.BaseServiceImpl;

@Service
public class OspatientServiceImpl extends BaseServiceImpl<OsPatient> implements OsPatientService{

	private OsPatientDao osPatientDao;
	@Resource
	public void setOsPatientDao(OsPatientDao osPatientDao) {
		super.setBaseDao(osPatientDao);
		this.osPatientDao = osPatientDao;
	}
	public List<OsPatient> login(String username, String password) {
		return osPatientDao.login(username, password);
	}
	public List<Map<Object, Object>> findByHot(int num, int size) {
		return osPatientDao.findByHot(num, size);
	}

	
	
}
