package com.osdoctor.dao.osOperaor.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.osOperaor.OsPatientDao;
import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.util.BaseDaoImpl;

@Repository
public class OsPatientDaoImpl extends BaseDaoImpl<OsPatient> implements OsPatientDao{

	
	
	public List<OsPatient> login(String username, String password) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OsPatient where username=? and password=? ").setString(0, username).setString(1, password).list();
	}

	public List<Map<Object, Object>> findByHot(int num,int size) {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("SELECT\n" +
				"	COUNT(pr.authorId) + (SELECT COUNT(pt_e.author) FROM patient_topic pt_e WHERE pt_e.author=op.id AND pt_e.views=1),\n" +
				"	op.id,\n" +
				"	op. NAME,\n" +
				"	op.photoPath , op.personalNote \n" +
				" FROM\n" +
				"	patient_reply pr\n" +
				" RIGHT JOIN os_patient op ON pr.authorId = op.id\n" +
				" WHERE\n" +
				"	(\n" +
				"		pr.views IS NULL\n" +
				"		OR pr.views != 0\n" +
				"	)\n" +
				" GROUP BY\n" +
				"	op.id\n" +
				" ORDER BY\n" +
				"	COUNT(pr.authorId) + (SELECT COUNT(pt_e.author) FROM patient_topic pt_e WHERE pt_e.author=op.id AND pt_e.views=1) DESC\n" +
				" LIMIT ?,\n" +
				" ?").setInteger(0, num*size).setInteger(1, size).list();
	}

}
