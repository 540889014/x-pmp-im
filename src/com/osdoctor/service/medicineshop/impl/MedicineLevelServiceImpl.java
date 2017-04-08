package com.osdoctor.service.medicineshop.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineInfoDao;
import com.osdoctor.dao.medicineshop.MedicineLevelDao;
import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.service.medicineshop.MedicineLevelService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class MedicineLevelServiceImpl extends BaseServiceImpl<MedicineLevel> implements MedicineLevelService{

	private MedicineLevelDao medicineLevelDao;
	@Resource
	public void setMedicineLevelDao(MedicineLevelDao medicineLevelDao) {
		super.setBaseDao(medicineLevelDao);
		this.medicineLevelDao = medicineLevelDao;
	}
	public List<Map<Object,Object>> findAllLevel_1_Objects() {

		
		return medicineLevelDao.findAllLevel_1_Object();
	}
	public List<Map<Object,Object>> findByIdLevel_2_Objects(Integer id) {

		
		return medicineLevelDao.findByIdLevel_2_Object(id);
	}
}
