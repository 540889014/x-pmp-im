package com.osdoctor.service.medicineshop.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineDetailDao;
import com.osdoctor.orm.medicineshop.MedicineDetail;
import com.osdoctor.service.medicineshop.MedicineDetailService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class MedicineDetailServiceImpl extends BaseServiceImpl<MedicineDetail> implements MedicineDetailService{

	private MedicineDetailDao medicineDetailDao;
	@Resource
	public void setRoleDao(MedicineDetailDao medicineDetailDao) {
		super.setBaseDao(medicineDetailDao);
		this.medicineDetailDao = medicineDetailDao;
	}
}
