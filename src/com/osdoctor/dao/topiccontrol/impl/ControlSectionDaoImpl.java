package com.osdoctor.dao.topiccontrol.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.osdoctor.dao.topiccontrol.ControlSectionDao;
import com.osdoctor.orm.topiccontrol.ControlSection;
import com.osdoctor.util.BaseDaoImpl;
@Repository
public class ControlSectionDaoImpl extends BaseDaoImpl<ControlSection> implements ControlSectionDao{

	public List<Map<Object, Object>> findAllSection() {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("select p.id,p.name , p.sectionIndex from control_topicsection p ").list();
	}

}
