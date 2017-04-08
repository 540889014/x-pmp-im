package com.osdoctor.orm.medicineshop;

import java.util.Date;

/**
 * 药品商城每日推荐
 * @author Administrator
 *
 */
public class MedicineDayRecommend {

	private Integer id;
	private MedicineInfo medicineInfo;//推荐的药品
	private int postion;//位置索引
	private Date time;//推荐时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MedicineInfo getMedicineInfo() {
		return medicineInfo;
	}
	public void setMedicineInfo(MedicineInfo medicineInfo) {
		this.medicineInfo = medicineInfo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPostion() {
		return postion;
	}
	public void setPostion(int postion) {
		this.postion = postion;
	}
	
}
