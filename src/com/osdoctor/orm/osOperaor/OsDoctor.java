package com.osdoctor.orm.osOperaor;

import java.util.HashSet;
import java.util.Set;


/**
 * 一医生类
 * @author javafengyu
 *
 */
public class OsDoctor implements java.io.Serializable{

	private Integer id;
	private String name;//医生名字
	private String doctorCode;//医生编号
	private String photoPath;
/*	private Set<OsCommunity> osCommunties = new HashSet<OsCommunity>();//设置医生和社康的多对多关系
*/	public OsDoctor(){
		
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
public String getDoctorCode() {
	return doctorCode;
}
public void setDoctorCode(String doctorCode) {
	this.doctorCode = doctorCode;
}
public String getPhotoPath() {
	return photoPath;
}
public void setPhotoPath(String photoPath) {
	this.photoPath = photoPath;
}
	
	
}
