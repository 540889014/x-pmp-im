package com.osdoctor.orm.topicdoctormine;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsDoctor;
import com.osdoctor.orm.topicCommon.TopicLabel;


/**
 * 医生模块的个人动态
 * @author javafengyu
 *
 */
public class DoctorMineTopic implements java.io.Serializable{

	private Integer id;
	private String title;//标题
	private String content;//内容
	private OsDoctor author;//主题作者
	private Date fabiaoTime;//发表时间
	private int praiseCount;//点赞的人数
	private String praiseId;//所有点赞人的Id,用逗号隔开,
	private Boolean views;
	private Set<PatientMineReply> doctorReplies = new HashSet<PatientMineReply>();//所有回复
	private int patientReplyCount;//回复总理
	private PatientMineReply lastDocReply;//最后回复
	private Date lastUpdateTime;//最后的回复的时间
	private Set<TopicLabel> topicLabels = new HashSet<TopicLabel>();//所属的标签

	public DoctorMineTopic(){
		
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

	public int getPraiseCount() {
		return praiseCount;
	}

	public Boolean getViews() {
		return views;
	}

	public void setViews(Boolean views) {
		this.views = views;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OsDoctor getAuthor() {
		return author;
	}

	public Set<TopicLabel> getTopicLabels() {
		return topicLabels;
	}

	public void setTopicLabels(Set<TopicLabel> topicLabels) {
		this.topicLabels = topicLabels;
	}

	public void setAuthor(OsDoctor author) {
		this.author = author;
	}

	public Date getFabiaoTime() {
		return fabiaoTime;
	}

	public String getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public void setFabiaoTime(Date fabiaoTime) {
		this.fabiaoTime = fabiaoTime;
	}

	public Set<PatientMineReply> getDoctorReplies() {
		return doctorReplies;
	}

	public void setDoctorReplies(Set<PatientMineReply> doctorReplies) {
		this.doctorReplies = doctorReplies;
	}

	public int getPatientReplyCount() {
		return patientReplyCount;
	}

	public void setPatientReplyCount(int patientReplyCount) {
		this.patientReplyCount = patientReplyCount;
	}

	public PatientMineReply getLastDocReply() {
		return lastDocReply;
	}

	public void setLastDocReply(PatientMineReply lastDocReply) {
		this.lastDocReply = lastDocReply;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}
