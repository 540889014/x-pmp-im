package com.osdoctor.orm.transaction;

import java.util.Date;

import com.osdoctor.orm.common.UserInfo;

public class ProjectInfo {

	private Long id;
	private String projectName;
	private Date startTime;
	private Date endTime;
	private String type;
	private UserInfo userInfo;//负责人，可以分配项目成员
//	private List<>
}
