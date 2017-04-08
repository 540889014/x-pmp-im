package com.osdoctor.orm.topicpatient;
/**
 * 帖子所包含的图片
 * @author admin
 *
 */
public class PatientTopicPhoto implements java.io.Serializable{

	private Integer id;
	private String photoPath;//照片地址
	private PatientTopic patientTopic;//所属的帖子
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public PatientTopic getPatientTopic() {
		return patientTopic;
	}
	public void setPatientTopic(PatientTopic patientTopic) {
		this.patientTopic = patientTopic;
	}
}
