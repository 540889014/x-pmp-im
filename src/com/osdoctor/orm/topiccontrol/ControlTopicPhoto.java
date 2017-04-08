package com.osdoctor.orm.topiccontrol;
/**
 * 帖子所包含的图片
 * @author admin
 *
 */
public class ControlTopicPhoto implements java.io.Serializable{

	private Integer id;
	private String photoPath;//照片地址
	private ControlTopic controlTopic;
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
	public ControlTopic getControlTopic() {
		return controlTopic;
	}
	public void setControlTopic(ControlTopic controlTopic) {
		this.controlTopic = controlTopic;
	}
}
