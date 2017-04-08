package com.osdoctor.orm.topiccontrol;

import java.util.Date;

import com.osdoctor.orm.osOperaor.OsDoctor;
import com.osdoctor.orm.osOperaor.OsPatient;

/**
 * 管理员模块的回复类
 * @author javafengyu
 *
 */
public class DoctorOrPatientReply implements java.io.Serializable{
	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsDoctor doctor;//医生回复
	private OsPatient patient;//患者回复
	private Date fabiaoTime;//发表时间
	private ControlTopic controlTopic;//所属帖子
	private boolean views=true;//是否显示，默认显示，相当于管理员删除违规回复
	public DoctorOrPatientReply(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public OsDoctor getDoctor() {
		return doctor;
	}
	public void setDoctor(OsDoctor doctor) {
		this.doctor = doctor;
	}
	public OsPatient getPatient() {
		return patient;
	}
	public void setPatient(OsPatient patient) {
		this.patient = patient;
	}
	public Date getFabiaoTime() {
		return fabiaoTime;
	}
	public void setFabiaoTime(Date fabiaoTime) {
		this.fabiaoTime = fabiaoTime;
	}
	public ControlTopic getControlTopic() {
		return controlTopic;
	}
	public void setControlTopic(ControlTopic controlTopic) {
		this.controlTopic = controlTopic;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	
}
