package com.osdoctor.dao.medicineshop.imp;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.medicineshop.MedicineLevelDao;
import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class MedicineLevelDaoImpl extends BaseDaoImpl<MedicineLevel> implements MedicineLevelDao{

	public List<Map<Object, Object>> findAllLevel_1_Object() {

		
		return getSession().createSQLQuery("select  id,name,remark,levelImg,postion,parentId  from shop_medicineLevel t where t.id=t.parentId ").list();
	}
	public List<Map<Object, Object>> findByIdLevel_2_Object(Integer id) {

		
		return getSession().createSQLQuery("select id,name,remark,levelImg,postion,parentId from shop_medicineLevel t where t.parentId ="+id+" and t.id!=t.parentId  ").list();
	}

}
