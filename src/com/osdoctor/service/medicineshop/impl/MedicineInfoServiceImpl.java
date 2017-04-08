package com.osdoctor.service.medicineshop.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.medicineshop.MedicineDetailDao;
import com.osdoctor.dao.medicineshop.MedicineInfoDao;
import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.service.medicineshop.MedicineInfoService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class MedicineInfoServiceImpl extends BaseServiceImpl<MedicineInfo> implements MedicineInfoService{

	private MedicineInfoDao medicineInfoDao;
	@Resource
	public void setRoleDao(MedicineInfoDao medicineInfoDao) {
		super.setBaseDao(medicineInfoDao);
		this.medicineInfoDao = medicineInfoDao;
	}
	public List<Map<Object, Object>> findMedicineByLevel_2_Id(Integer id) {
		// TODO Auto-generated method stub
		return medicineInfoDao.findMedicineByLevel_2_Id(id);
	}
}
