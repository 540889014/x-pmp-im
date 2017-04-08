package com.osdoctor.dao.medicineshop;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.util.BaseDao;

public interface MedicineInfoDao extends BaseDao<MedicineInfo>{

	//根据二级分类获取药品信息
	public List<Map<Object, Object>> findMedicineByLevel_2_Id(Integer id);
}
