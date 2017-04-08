package com.osdoctor.orm.medicineshop;

import java.util.HashSet;
import java.util.Set;


/**
 * 药品的分类
 * @author javafengyu
 *
 */
public class MedicineLevel {

	private Integer id;
	private String name;//药品的分类名
	private String remark;//备注
	private String levelImg;//分类图
	private int postion;//位置索引值
	private MedicineLevel parentLevel;//上级分类
	private Set<MedicineLevel> medicineLeveles = new HashSet<MedicineLevel>();//下级分类
	private Set<MedicineInfo> medicines = new HashSet<MedicineInfo>();//该分类下的商品
	public MedicineLevel(){
		
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLevelImg() {
		return levelImg;
	}
	public void setLevelImg(String levelImg) {
		this.levelImg = levelImg;
	}
	public int getPostion() {
		return postion;
	}
	public void setPostion(int postion) {
		this.postion = postion;
	}
	public MedicineLevel getParentLevel() {
		return parentLevel;
	}
	public void setParentLevel(MedicineLevel parentLevel) {
		this.parentLevel = parentLevel;
	}
	public Set<MedicineLevel> getMedicineLeveles() {
		return medicineLeveles;
	}
	public void setMedicineLeveles(Set<MedicineLevel> medicineLeveles) {
		this.medicineLeveles = medicineLeveles;
	}
	public Set<MedicineInfo> getMedicines() {
		return medicines;
	}
	public void setMedicines(Set<MedicineInfo> medicines) {
		this.medicines = medicines;
	}
}
