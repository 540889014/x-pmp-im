package com.jd.x.orm.friends;

import java.util.Date;

import com.jd.x.orm.common.UserInfo;

public class MessageInfo {

	private Integer id;
	private String message;
	private UserInfo sendUser;//发件人
	private UserInfo recUser;//收件人
	private Date sendDate;//发送时间
}
