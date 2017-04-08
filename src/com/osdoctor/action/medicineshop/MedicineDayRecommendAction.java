package com.osdoctor.action.medicineshop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineDayRecommend;
import com.osdoctor.util.HqlHelper;
/**
 * 商城每日推荐
 * @author 小小_Code
 *
 */
public class MedicineDayRecommendAction extends BaseAction<MedicineDayRecommend>{

	/**
	 * 获取主页的推荐信息
	 * @return
	 */
	public String Index_DayRecommendInfoList()
	{
		//获取当前时间
		Calendar nowU=Calendar.getInstance();
		String now=nowU.get(Calendar.YEAR)+"-"+(nowU.get(Calendar.MONTH)+1)+"-"+nowU.get(Calendar.DATE);
		//创建查询，查询当天的推荐信息
		HqlHelper hqlHelper=new HqlHelper(MedicineDayRecommend.class, "recommend");
		hqlHelper.addWhereCondition("date_format(time,'%Y-%m-%d')=date_format(?,'%Y-%m-%d')", now);
		recommends=medicineDayRecommendService.findObjects(hqlHelper);
		//设置Header，实现跨域访问
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		response.setHeader("Cache-Control", "no-cache");
		return "dayRecommendInfoList";
	}
	//----------------------------------需要返回的参数-----------------------------------------
	List<MedicineDayRecommend> recommends=new ArrayList<MedicineDayRecommend>();
	public List<MedicineDayRecommend> getRecommends() {
		return recommends;
	}
	public void setRecommends(List<MedicineDayRecommend> recommends) {
		this.recommends = recommends;
	}
	
}
