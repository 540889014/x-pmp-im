package com.osdoctor.service.medicineshop;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.BaseService;

public interface MedicineLevelService extends BaseService<MedicineLevel>{
       
	//获取所有的一级药品分类
	public List<Map<Object,Object>> findAllLevel_1_Objects();
	
	//获取一级药品对应的二级分类
	public List<Map<Object,Object>> findByIdLevel_2_Objects(Integer id);
}
