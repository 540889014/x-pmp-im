package com.osdoctor.orm.topiccontrol;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.osdoctor.orm.osOperaor.OsControl;


/**
 * 管理员模块的版块类
 * @author javafengyu
 *
 */
public class ControlSection implements java.io.Serializable{

	private Integer id;
	private String name;//主题名
	private String miaoshu;//主题分类的描述
	private int topicCount;//主题总数
	private int huoyueCount;//活跃量=主题+回复
	private Date jiansheDate;//版块建设的时间
	private int sectionIndex;//版块位置的索引值
	private OsControl osControl;//建设版块的管理员
	private Set<ControlTopic> topices = new HashSet<ControlTopic>();//该版块下所属的主题
	public ControlSection(){
		
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
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public int getHuoyueCount() {
		return huoyueCount;
	}
	public void setHuoyueCount(int huoyueCount) {
		this.huoyueCount = huoyueCount;
	}
	public Date getJiansheDate() {
		return jiansheDate;
	}
	public void setJiansheDate(Date jiansheDate) {
		this.jiansheDate = jiansheDate;
	}
	public int getSectionIndex() {
		return sectionIndex;
	}
	public void setSectionIndex(int sectionIndex) {
		this.sectionIndex = sectionIndex;
	}
	public Set<ControlTopic> getTopices() {
		return topices;
	}
	public void setTopices(Set<ControlTopic> topices) {
		this.topices = topices;
	}
	public OsControl getOsControl() {
		return osControl;
	}
	public void setOsControl(OsControl osControl) {
		this.osControl = osControl;
	}
	
}
