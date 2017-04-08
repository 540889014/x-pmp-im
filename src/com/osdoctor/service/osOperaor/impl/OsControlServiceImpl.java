package com.osdoctor.service.osOperaor.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.osdoctor.dao.osOperaor.OsControlDao;
import com.osdoctor.orm.osOperaor.OsControl;
import com.osdoctor.service.osOperaor.OsControlService;
import com.osdoctor.util.BaseServiceImpl;
@Service
public class OsControlServiceImpl extends BaseServiceImpl<OsControl> implements OsControlService{
	private OsControlDao osControlDao;
	@Resource
	public void setOsControlDao(OsControlDao osControlDao) {
		super.setBaseDao(osControlDao);
		this.osControlDao = osControlDao;
	}
}
