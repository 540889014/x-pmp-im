package com.osdoctor.orm.topicdoctormine;

import java.util.Date;

import com.osdoctor.orm.osOperaor.OsPatient;


/**
 * 患者模块的回复类
 * @author javafengyu
 *
 */
public class PatientMineReply implements java.io.Serializable{
	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsPatient author;//回复人
	private Date fabiaoTime;//回复时间
	private DoctorMineTopic patientTopic;//所属帖子
	private boolean views=true;//是否显示，默认显示，相当于管理员删除违规回复
	public PatientMineReply(){
		
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
	public OsPatient getAuthor() {
		return author;
	}
	public void setAuthor(OsPatient author) {
		this.author = author;
	}
	public Date getFabiaoTime() {
		return fabiaoTime;
	}
	public void setFabiaoTime(Date fabiaoTime) {
		this.fabiaoTime = fabiaoTime;
	}
	public DoctorMineTopic getPatientTopic() {
		return patientTopic;
	}
	public void setPatientTopic(DoctorMineTopic patientTopic) {
		this.patientTopic = patientTopic;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
}
