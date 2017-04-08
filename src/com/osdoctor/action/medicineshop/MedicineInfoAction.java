package com.osdoctor.action.medicineshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.util.HqlHelper;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MedicineInfoAction extends BaseAction<MedicineInfo>{

	
	/**
	 * 根据二级分类ID，获取药品信息
	 * @return
	 */
	public String ById_Medicine_InfoList()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Integer id=Integer.parseInt(request.getParameter("id"));
		MedicineInfos=medicineInfoService.findMedicineByLevel_2_Id(id);
		//解决跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "ById_Medicine_InfoList";
	}
	public String ByMedicineId_Medicine_InfoList()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Integer id=Integer.parseInt(request.getParameter("InfoId"));
		HqlHelper hqlHelper=new HqlHelper(MedicineInfo.class, "medicine");
		hqlHelper.addWhereCondition("id=?", id);
		medicineInfos2=medicineInfoService.findObjects(hqlHelper);
		//解决跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "ByMedicineId_Medicine_InfoList";
	}
	
	//----------------------------------需要返回的参数-----------------------------------------
	List<Map<Object, Object>> MedicineInfos=new ArrayList<Map<Object,Object>>();
	List<MedicineInfo> medicineInfos2=new ArrayList<MedicineInfo>();
	public List<Map<Object, Object>> getMedicineInfos() {
		return MedicineInfos;
	}
	public void setMedicineInfos(List<Map<Object, Object>> medicineInfos) {
		MedicineInfos = medicineInfos;
	}
	public List<MedicineInfo> getMedicineInfos2() {
		return medicineInfos2;
	}
	public void setMedicineInfos2(List<MedicineInfo> medicineInfos2) {
		this.medicineInfos2 = medicineInfos2;
	}
	
}
