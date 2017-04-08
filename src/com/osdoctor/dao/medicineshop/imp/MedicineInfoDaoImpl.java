package com.osdoctor.dao.medicineshop.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.medicineshop.MedicineInfoDao;
import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class MedicineInfoDaoImpl extends BaseDaoImpl<MedicineInfo> implements MedicineInfoDao{

	public List<Map<Object, Object>> findMedicineByLevel_2_Id(Integer id) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery(" SELECT\n" +
				"	t.id,\n" +
				"	t. NAME,\n" +
				"	t.notice,\n" +
				"	t.medicineId,\n" +
				"	t.medicinePrice,\n" +
				"	t.medicineLevelId,\n" +
				"	t.medicineDetailId,\n" +
				"	t.medicineNewPrice,\n" +
				"	t.attending,\n" +
				"	t.commonName,\n" +
				"	t.indication,\n" +
				"	t.manufacturer,\n" +
				"	t.medicineWord,\n" +
				"	t.standard,\n" +
				"	t.usageAndDosage,\n" +
				"	t.pharmacy,\n" +
				"	t1.content,\n" +
				"	t1.detailImg\n" +
				"FROM\n" +
				"	shop_medicineInfo t\n" +
				"INNER JOIN\n" +
				"shop_medicinedetail t1\n" +
				" ON t.medicineDetailId=t1.id\n" +
					"WHERE\n" +
				"	t.medicineLevelId ="+id+" ").list();
	}

}
