package com.jd.x.orm.transaction;

import java.util.Date;

import com.jd.x.orm.common.UserInfo;

public class TransactionInfo {

	private Integer id;
	private String name;
	private Date start;
	private Date end;
	private String detail;
	private String duty;
	private String summary;
	private UserInfo userInfo;
	private ProjectInfo projectInfo;
}
