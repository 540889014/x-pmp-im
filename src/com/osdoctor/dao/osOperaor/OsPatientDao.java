package com.osdoctor.dao.osOperaor;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.util.BaseDao;
/**
 * 	患者用户信息Service
 * @author admin
 *
 */
public interface OsPatientDao extends BaseDao<OsPatient>{

	//患者用户登录
	List<OsPatient> login(String username,String password);
	//获取活跃用户
	List<Map<Object, Object>> findByHot(int num,int size);
}
