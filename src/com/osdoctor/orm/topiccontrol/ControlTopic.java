package com.osdoctor.orm.topiccontrol;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsControl;
import com.osdoctor.orm.topicCommon.TopicLabel;


/**
 * 管理员模块的主题类
 * @author javafengyu
 *
 */
public class ControlTopic implements java.io.Serializable{

	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsControl author;//主题作者
	private Date fabiaoTime;//发表时间
	private int praiseCount;//点赞的人数
	private String praiseId;//所有点赞人的Id中间用,隔开
	private boolean views;//是否显示
	//关联信息
	private ControlSection controlSection;//所属版块
	private Set<TopicLabel> topicLabels = new HashSet<TopicLabel>();//所属话题
	private Set<DoctorOrPatientReply> doctorOrPatientReplies = new HashSet<DoctorOrPatientReply>();//所有回复
	private int doctorOrPatientReplyCount;//回复总理
	private DoctorOrPatientReply doctorOrPatientReply;//最后回复
	private Date lastUpdateTime;//最后的回复的时间
	private int controlTopicType;//主题类型(待定，活跃级别或系统运营)
	public ControlTopic(){
		
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
	
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public OsControl getAuthor() {
		return author;
	}
	public void setAuthor(OsControl author) {
		this.author = author;
	}
	public Date getFabiaoTime() {
		return fabiaoTime;
	}
	public void setFabiaoTime(Date fabiaoTime) {
		this.fabiaoTime = fabiaoTime;
	}
	public ControlSection getControlSection() {
		return controlSection;
	}
	public void setControlSection(ControlSection controlSection) {
		this.controlSection = controlSection;
	}
	public Set<TopicLabel> getTopicLabels() {
		return topicLabels;
	}
	public void setTopicLabels(Set<TopicLabel> topicLabels) {
		this.topicLabels = topicLabels;
	}
	public int getDoctorOrPatientReplyCount() {
		return doctorOrPatientReplyCount;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	public void setDoctorOrPatientReplyCount(int doctorOrPatientReplyCount) {
		this.doctorOrPatientReplyCount = doctorOrPatientReplyCount;
	}
	public Set<DoctorOrPatientReply> getDoctorOrPatientReplies() {
		return doctorOrPatientReplies;
	}
	public void setDoctorOrPatientReplies(
			Set<DoctorOrPatientReply> doctorOrPatientReplies) {
		this.doctorOrPatientReplies = doctorOrPatientReplies;
	}
	public DoctorOrPatientReply getDoctorOrPatientReply() {
		return doctorOrPatientReply;
	}
	public void setDoctorOrPatientReply(DoctorOrPatientReply doctorOrPatientReply) {
		this.doctorOrPatientReply = doctorOrPatientReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	public int getControlTopicType() {
		return controlTopicType;
	}
	public void setControlTopicType(int controlTopicType) {
		this.controlTopicType = controlTopicType;
	}
	
	
}
