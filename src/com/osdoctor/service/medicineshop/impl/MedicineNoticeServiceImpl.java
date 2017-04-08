package com.osdoctor.service.medicineshop.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineLevelDao;
import com.osdoctor.dao.medicineshop.MedicineNoticeDao;
import com.osdoctor.orm.medicineshop.MedicineNotice;
import com.osdoctor.service.medicineshop.MedicineNoticeService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class MedicineNoticeServiceImpl extends BaseServiceImpl<MedicineNotice> implements MedicineNoticeService{

	private MedicineNoticeDao medicineNoticeDao;
	@Resource
	public void setRoleDao(MedicineNoticeDao medicineNoticeDao) {
		super.setBaseDao(medicineNoticeDao);
		this.medicineNoticeDao = medicineNoticeDao;
	}
}
