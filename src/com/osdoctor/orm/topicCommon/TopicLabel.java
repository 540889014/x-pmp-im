package com.osdoctor.orm.topicCommon;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsControl;
import com.osdoctor.orm.osOperaor.OsPatient;
import com.osdoctor.orm.topiccontrol.ControlTopic;
import com.osdoctor.orm.topicdoctormine.DoctorMineTopic;
import com.osdoctor.orm.topicpatient.PatientTopic;


/**
 * 标签（话题）类
 * @author javafengyu
 *
 */
public class TopicLabel implements java.io.Serializable{

	private Integer id;
	private String name;//标签名
	private OsControl osControl;//创建人
	private Date CreateTime;//创建时间
	private Integer type;//标识该标签属于哪个圈子（1代表后台资讯，2代表医生和医生之间的，3代表医生发患者看的，4代表患者和患者之间的）
	private boolean views;//是否显示
	private Set<PatientTopic> patientTopics = new HashSet<PatientTopic>();//该标签下所属的患者与患者之间的帖子，与帖子多对多的关系
	private Set<DoctorMineTopic> doctorMineTopics = new HashSet<DoctorMineTopic>();//该标签下所属的医生与患者之间的帖子，与帖子多对多的关系
	private Set<ControlTopic> controlTopics = new HashSet<ControlTopic>();  //该标签下所属的系统帖子（资讯），与帖子多对多的关系
	public TopicLabel(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PatientTopic> getPatientTopics() {
		return patientTopics;
	}
	public void setPatientTopics(Set<PatientTopic> patientTopics) {
		this.patientTopics = patientTopics;
	}
	public Set<DoctorMineTopic> getDoctorMineTopics() {
		return doctorMineTopics;
	}
	public void setDoctorMineTopics(Set<DoctorMineTopic> doctorMineTopics) {
		this.doctorMineTopics = doctorMineTopics;
	}
	public OsControl getOsControl() {
		return osControl;
	}
	public void setOsControl(OsControl osControl) {
		this.osControl = osControl;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public boolean isViews() {
		return views;
	}
	public Set<ControlTopic> getControlTopics() {
		return controlTopics;
	}
	public void setControlTopics(Set<ControlTopic> controlTopics) {
		this.controlTopics = controlTopics;
	}
	public void setViews(boolean views) {
		this.views = views;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
}
