package com.osdoctor.dao.medicineshop;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.BaseDao;

public interface MedicineLevelDao extends BaseDao<MedicineLevel>{

	//获取所有的一级药品分类
	public List<Map<Object,Object>> findAllLevel_1_Object();
	//获取一级药品对应的二级分类
	public List<Map<Object,Object>> findByIdLevel_2_Object(Integer id);
}
