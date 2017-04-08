package com.osdoctor.orm.osOperaor;

import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.topicCommon.TopicLabel;
import com.osdoctor.orm.topicpatient.PatientTopic;

/**
 * 患者类
 * @author javafengyu
 *
 */
public class OsPatient implements java.io.Serializable{


	private Integer id;
	private String name;//患者端用户姓名
	private String username;//登录名
	private String password;//登录密码
	private String photoPath;//图像地址
	private String personalNote;//个人说明
	private Set<OsDoctor> osDoctors = new HashSet<OsDoctor>();//患者关注的医生
	private Set<TopicLabel> patientLabels = new HashSet<TopicLabel>();//用户关注的的标签

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public Set<TopicLabel> getPatientLabels() {
		return patientLabels;
	}


	public void setPatientLabels(Set<TopicLabel> patientLabels) {
		this.patientLabels = patientLabels;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhotoPath() {
		return photoPath;
	}


	public String getPersonalNote() {
		return personalNote;
	}


	public void setPersonalNote(String personalNote) {
		this.personalNote = personalNote;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Set<OsDoctor> getOsDoctors() {
		return osDoctors;
	}


	public void setOsDoctors(Set<OsDoctor> osDoctors) {
		this.osDoctors = osDoctors;
	}

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
