package com.osdoctor.dao.topiccontrol;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topiccontrol.ControlSection;
import com.osdoctor.util.BaseDao;

public interface ControlSectionDao extends BaseDao<ControlSection>{

	/**
	 * 获取所有版块
	 * @return
	 */
	List<Map<Object, Object>> findAllSection();
}
