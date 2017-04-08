package com.osdoctor.service.topiccontrol;

import java.util.List;
import java.util.Map;

import com.osdoctor.orm.topiccontrol.ControlSection;
import com.osdoctor.util.BaseService;

public interface ControlSectionService extends BaseService<ControlSection>{

	
	/**
	 * 获取所有版块
	 * @return
	 */
	List<Map<Object, Object>> findAllSection();
}
