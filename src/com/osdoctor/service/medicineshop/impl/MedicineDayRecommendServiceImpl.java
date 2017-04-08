package com.osdoctor.service.medicineshop.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineDayRecommendDao;
import com.osdoctor.dao.medicineshop.MedicineDetailDao;
import com.osdoctor.orm.medicineshop.MedicineDayRecommend;
import com.osdoctor.service.medicineshop.MedicineDayRecommendService;
import com.osdoctor.util.BaseServiceImpl;

@Service
public class MedicineDayRecommendServiceImpl extends BaseServiceImpl<MedicineDayRecommend> implements MedicineDayRecommendService{

	
	private MedicineDayRecommendDao medicineDayRecommendDao;
	@Resource
	public void setMedicineDayRecommendDao(MedicineDayRecommendDao medicineDayRecommendDao) {
		super.setBaseDao(medicineDayRecommendDao);
		this.medicineDayRecommendDao = medicineDayRecommendDao;
	}
	
}
