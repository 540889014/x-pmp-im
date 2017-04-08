package com.osdoctor.action.medicineshop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineNotice;
import com.osdoctor.util.HqlHelper;
/**
 * 商城广告
 * @author 李昭辉
 *
 */
public class MedicineNoticeAction extends BaseAction<MedicineNotice>{

	
	/**
	 * 商城主页广告信息
	 * @return
	 */
	public String Index_noticeInfoList()
	{
		HqlHelper hqlHelper=new HqlHelper(MedicineNotice.class, "notice");
		hqlHelper.addWhereCondition("view = ?", true);
		notices=medicineNoticeService.getPageBean(hqlHelper, 1, 4).getRecordList();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "noticeInfoList";
	}
	/////////////////////参数信息//////////////////////////////////
	List<MedicineNotice> notices=new ArrayList<MedicineNotice>();
	public List<MedicineNotice> getNotices() {
		return notices;
	}
	public void setNotices(List<MedicineNotice> notices) {
		this.notices = notices;
	}
}
