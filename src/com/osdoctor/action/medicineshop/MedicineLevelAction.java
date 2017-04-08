package com.osdoctor.action.medicineshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.HqlHelper;

/**
 * 药品分类Action
 * @author 李昭辉
 *
 */
public class MedicineLevelAction extends BaseAction<MedicineLevel>{

	/**
	 * 主页显示的七个一级分类信息
	 * @return
	 */
	public String Index_LevelInfoList() {
		
		//创建查询，查询前七位的一级分类信息
		HqlHelper hqlHelper=new HqlHelper(MedicineLevel.class, "level");
		hqlHelper.addWhereCondition("level.parentLevel.id=level.id and level.postion>=1 and level.postion<=7", null);
		levels=medicineLevelService.findObjects(hqlHelper);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "levelInfoList";
	}
	/**
	 * 获取所有的一级分类
	 * @return
	 */
	public String All_Level_1_InfoList() {
		
		HqlHelper hqlHelper=new HqlHelper(MedicineLevel.class, "level");
		level_1=medicineLevelService.findAllLevel_1_Objects();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "alllevel_1_InfoList";
	}
	/**
	 * 获取一级分类对应的二级分类
	 * @return
	 */
	public String ById_Level_2_InfoList() {
		
		//创建查询，查询当前一级分类下的二级分类信息
		HqlHelper hqlHelper=new HqlHelper(MedicineLevel.class, "level");
		level_1=medicineLevelService.findAllLevel_1_Objects();
		HttpServletRequest request=ServletActionContext.getRequest();
		Integer id=Integer.parseInt(request.getParameter("id"));
		level_2=medicineLevelService.findByIdLevel_2_Objects(id);
		//解决跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "alllevel_2_InfoList";
	}
	
	//----------------------------------需要返回的参数-----------------------------------------
	List<MedicineLevel> levels=new ArrayList<MedicineLevel>();
	List<Map<Object, Object>> level_1=new ArrayList<Map<Object,Object>>();
	List<Map<Object, Object>> level_2=new ArrayList<Map<Object,Object>>();

	public List<MedicineLevel> getLevels() {
		return levels;
	}

	public void setLevels(List<MedicineLevel> levels) {
		this.levels = levels;
	}
	public List<Map<Object, Object>> getLevel_1() {
		return level_1;
	}
	public void setLevel_1(List<Map<Object, Object>> level_1) {
		this.level_1 = level_1;
	}
	public List<Map<Object, Object>> getLevel_2() {
		return level_2;
	}
	public void setLevel_2(List<Map<Object, Object>> level_2) {
		this.level_2 = level_2;
	}
	
}
