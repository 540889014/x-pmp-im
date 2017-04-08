package com.osdoctor.service.osOperaor;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.util.BaseService;
/**
 * 	患者用户信息Dao
 * @author admin
 *
 */
public interface OsPatientService extends BaseService<OsPatient>{

	//患者用户登录
	List<OsPatient> login(String username,String password);
	//获取活跃用户
	List<Map<Object, Object>> findByHot(int num,int size);
}
