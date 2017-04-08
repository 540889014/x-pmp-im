package com.osdoctor.orm.osOperaor;

/**
 * 控制中心操作员
 * @author javafengyu
 *
 */
public class OsControl implements java.io.Serializable{

	private Integer id;
	private String name;
	private String photoPath;//用户头像

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
