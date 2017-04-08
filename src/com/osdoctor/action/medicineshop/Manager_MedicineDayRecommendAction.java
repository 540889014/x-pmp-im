package com.osdoctor.action.medicineshop;


import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineDayRecommend;
import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.util.HqlHelper;

public class Manager_MedicineDayRecommendAction extends BaseAction<MedicineDayRecommend>{
	/**
	 * 列表
	 * @return
	 */
	public String list(){
		ActionContext.getContext().getValueStack().push(medicineDayRecommendService.getPageBean(new HqlHelper(MedicineDayRecommend.class, "m"), 0, 10));
		return "list";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String addar(){
		 ActionContext.getContext().getValueStack().push(medicineInfoService.getById(model.getId()));
		return "addar";
		
	}
	public String add(){
		MedicineInfo info= medicineInfoService.getById(model.getId());
		model.setTime(new Date());
		model.setMedicineInfo(info);
		medicineDayRecommendService.save(model);
		return "add";
		
	}
	/**
	 * 更新页面
	 * @return
	 */
	public String updatear(){
		 ActionContext.getContext().getValueStack().push(medicineDayRecommendService.getById(model.getId()));
		return "updatear";
		
	}
	/**
	 * 更新
	 * @return
	 */
	public String update(){
		MedicineDayRecommend dayRecommend= medicineDayRecommendService.getById(model.getId());
		dayRecommend.setPostion(model.getPostion());
		medicineDayRecommendService.update(dayRecommend);
		return "update";
		
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		medicineDayRecommendService.delete(model.getId());
		return "delete";
		
	}
	
	
}
