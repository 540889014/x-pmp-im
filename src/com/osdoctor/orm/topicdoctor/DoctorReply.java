package com.osdoctor.orm.topicdoctor;

import java.util.Date;

import com.osdoctor.orm.osOperaor.OsDoctor;


/**
 * 医生模块的回复类
 * @author javafengyu
 *
 */
public class DoctorReply implements java.io.Serializable{
	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsDoctor author;//主题作者
	private Date fabiaoTime;//发表时间
	private boolean views=true;//是否显示，默认显示，相当于管理员删除违规回复
	private DoctorTopic doctorTopic;//所属主题
	public DoctorReply(){
		
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
	public OsDoctor getAuthor() {
		return author;
	}
	public void setAuthor(OsDoctor author) {
		this.author = author;
	}
	public Date getFabiaoTime() {
		return fabiaoTime;
	}
	public void setFabiaoTime(Date fabiaoTime) {
		this.fabiaoTime = fabiaoTime;
	}
	public DoctorTopic getDoctorTopic() {
		return doctorTopic;
	}
	public void setDoctorTopic(DoctorTopic doctorTopic) {
		this.doctorTopic = doctorTopic;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	
}
