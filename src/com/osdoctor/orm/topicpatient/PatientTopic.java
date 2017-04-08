package com.osdoctor.orm.topicpatient;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsDoctor;
import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.orm.topicCommon.TopicLabel;
import com.osdoctor.orm.topicdoctor.DoctorReply;

/**
 * 患者模块的主题（帖子）类
 * @author javafengyu
 *
 */
public class PatientTopic implements java.io.Serializable{

	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsPatient author;//帖子作者
	private Date fabiaoTime;//发表时间
	private int patientReplyCount;//回复总数
	private int praiseCount;//点赞的人数
	private String praiseId;//点赞人数的ID,之间用'|'隔开，如果用户的ID在里面包含就不能再点赞了，
	private boolean views=true;//是否显示，默认显示，相当于管理员删除违规帖子
	//关联信息
	private Set<PatientTopicPhoto> patientTopicPhotos = new HashSet<PatientTopicPhoto>();
	private PatientSection patientSection;//所属版块
	private PatientReply lastPatReply;//最后回复
	private Date lastUpdateTime;//最后的回复的时间
	private Set<PatientReply> patientReplies = new HashSet<PatientReply>();//所有回复
	private int patientTopicType;//主题类型(待定，活跃级别或系统运营)
	private Set<TopicLabel> patientLabels = new HashSet<TopicLabel>();//该主题属于哪些标签，与标签多对多
	
	public PatientTopic(){
		
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
	public PatientSection getPatientSection() {
		return patientSection;
	}
	public void setPatientSection(PatientSection patientSection) {
		this.patientSection = patientSection;
	}
	public Set<PatientReply> getPatientReplies() {
		return patientReplies;
	}
	public void setPatientReplies(Set<PatientReply> patientReplies) {
		this.patientReplies = patientReplies;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	public int getPatientReplyCount() {
		return patientReplyCount;
	}
	public int getPatientTopicType() {
		return patientTopicType;
	}
	public Set<PatientTopicPhoto> getPatientTopicPhotos() {
		return patientTopicPhotos;
	}
	public void setPatientTopicPhotos(Set<PatientTopicPhoto> patientTopicPhotos) {
		this.patientTopicPhotos = patientTopicPhotos;
	}
	public void setPatientTopicType(int patientTopicType) {
		this.patientTopicType = patientTopicType;
	}
	public boolean isViews() {
		return views;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public PatientReply getLastPatReply() {
		return lastPatReply;
	}
	public void setLastPatReply(PatientReply lastPatReply) {
		this.lastPatReply = lastPatReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public void setPatientReplyCount(int patientReplyCount) {
		this.patientReplyCount = patientReplyCount;
	}
	public Set<TopicLabel> getPatientLabels() {
		return patientLabels;
	}
	public void setPatientLabels(Set<TopicLabel> patientLabels) {
		this.patientLabels = patientLabels;
	}

	
}
