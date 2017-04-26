package com.jd.x.orm.friends;

import java.util.Date;

import com.jd.x.orm.common.UserInfo;

public class MessageInfo {

	private Integer id;
	private String message;
	private UserInfo sendUser;//发件人
	private UserInfo recUser;//收件人
	private Date sendDate;//发送时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserInfo getSendUser() {
		return sendUser;
	}
	public void setSendUser(UserInfo sendUser) {
		this.sendUser = sendUser;
	}
	public UserInfo getRecUser() {
		return recUser;
	}
	public void setRecUser(UserInfo recUser) {
		this.recUser = recUser;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
}
