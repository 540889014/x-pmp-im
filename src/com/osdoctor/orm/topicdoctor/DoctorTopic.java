package com.osdoctor.orm.topicdoctor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsDoctor;


/**
 * 医生模块的主题类
 * @author javafengyu
 *
 */
public class DoctorTopic implements java.io.Serializable{

	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsDoctor author;//主题作者
	private Date fabiaoTime;//发表时间
	//关联信息
	private DoctorSection doctorSection;//所属版块
	private Set<DoctorReply> doctorReplies = new HashSet<DoctorReply>();//所有回复
	private int doctorReplyCount;//回复总理
	private DoctorReply lastDocReply;//最后回复
	private Date lastUpdateTime;//最后的回复的时间
	private int doctorTopicType;//主题类型(待定，活跃级别或系统运营)
	private boolean views=true;//是否显示，默认显示，相当于管理员删除违规回复
	public DoctorTopic(){
		
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
	public DoctorSection getDoctorSection() {
		return doctorSection;
	}
	public void setDoctorSection(DoctorSection doctorSection) {
		this.doctorSection = doctorSection;
	}
	public Set<DoctorReply> getDoctorReplies() {
		return doctorReplies;
	}
	public void setDoctorReplies(Set<DoctorReply> doctorReplies) {
		this.doctorReplies = doctorReplies;
	}
	public int getDoctorReplyCount() {
		return doctorReplyCount;
	}
	public void setDoctorReplyCount(int doctorReplyCount) {
		this.doctorReplyCount = doctorReplyCount;
	}
	public DoctorReply getLastDocReply() {
		return lastDocReply;
	}
	public void setLastDocReply(DoctorReply lastDocReply) {
		this.lastDocReply = lastDocReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getDoctorTopicType() {
		return doctorTopicType;
	}
	public void setDoctorTopicType(int doctorTopicType) {
		this.doctorTopicType = doctorTopicType;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	
	
}
