package com.osdoctor.action.medicineshop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.HqlHelper;

/**
 * 药品分类Action
 *
 */
public class Manager_MedicineLevelAction extends BaseAction<MedicineLevel>{
	protected File upload;// 对应 页面 input name名
	protected String uploadFileName;// 上传文件的名字
	protected String uploadContentType;// 上传文件的类型
	protected String result;
	/**
	 * 分类列表
	 * 
	 * @return
	 */
	public String levellist() {
		ActionContext.getContext().getValueStack().push(medicineLevelService.getPageBean(new HqlHelper(MedicineLevel.class, "m").addWhereCondition("m.parentLevel.id=null"),1, 10));
		return "levellist";
	}
	/**
	 * 添加分类页面
	 * @return
	 */
	public String leveladdar() {
		return "leveladdar";
		
	}
	/**
	 * 添加分类
	 * @return
	 * @throws IOException 
	 */
	public String leveladd() throws IOException {
		String pathBase = "/upload/medicineImg/";
		String path = ServletActionContext.getServletContext().getRealPath(
				pathBase);
		File file = new File(path);
		System.out.println(uploadFileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));//
		model.setLevelImg(pathBase + uploadFileName);
		medicineLevelService.save(model);
		return "leveladd";
		
	}
	/**
	 * 更新分类页面
	 * @return
	 */
	public String levelupdatear() {
		ActionContext.getContext().getValueStack().push(medicineLevelService.getById(model.getId()));
		return "levelupdatear";
		
	}
	/**
	 * 更新页面
	 * @return
	 * @throws Exception 
	 */
	public String levelupdate() throws Exception {
		MedicineLevel entity = medicineLevelService.getById(model.getId());
		if (uploadFileName != null) {
			String pathBase = "/upload/medicineImg/";
			String path = ServletActionContext.getServletContext().getRealPath(
					pathBase);
			File file = new File(path);
			System.out.println("xin"+uploadFileName);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileUtils.copyFile(upload, new File(file, uploadFileName));//
			entity.setLevelImg(pathBase + uploadFileName);
		}
		entity.setName(model.getName());
		entity.setPostion(model.getPostion());
		entity.setRemark(model.getRemark());
		medicineLevelService.update(entity);
		return "levelupdate";
	}
	/**
	 * 删除分类
	 * @return
	 */
	public String leveldelete(){
		MedicineLevel level=medicineLevelService.getById(model.getId());
		//把二级菜单全部删除
		if(level.getMedicineLeveles().size()>0){
			List<MedicineLevel> levels = new ArrayList<MedicineLevel>(level.getMedicineLeveles());
			for(int i=0;i<levels.size();i++){
				medicineLevelService.delete(levels.get(i).getId());
			}
		}
		medicineLevelService.delete(model.getId());
		return "leveldelete";
		
	}
	
/////////////////////////////////商城二级分类
	/**
	 * 分类列表
	 * 
	 * @return
	 */
	public String erjilist() {
		System.out.println(model.getId());
		ActionContext.getContext().getValueStack().push(medicineLevelService.getPageBean(new HqlHelper(MedicineLevel.class, "m").addWhereCondition("m.parentLevel.id=?", model.getId()),1, 10));
		return "erjilist";
	}
    /**
     * 添加分类页面
     * @return
     */
	public String erjiaddar() {
		ActionContext.getContext().getValueStack().push(medicineLevelService.getById(model.getId()));
		return "erjiaddar";

	}
    /**
     * 添加分类
     * @return
     * @throws IOException 
     */
	public String erjiadd() throws IOException {
		String pathBase = "/upload/medicineImg/";
		String path = ServletActionContext.getServletContext().getRealPath(
				pathBase);
		File file = new File(path);
		System.out.println(uploadFileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));//
		MedicineLevel yijilevel = medicineLevelService.getById(model.getId());
		model.setLevelImg(pathBase + uploadFileName);
		medicineLevelService.save(model);
		yijilevel.getMedicineLeveles().add(model);
		//添加完二级分类后转到当前二级分类列表
		ActionContext.getContext().getValueStack().push(yijilevel);
		//
		medicineLevelService.update(yijilevel);
		return "erjiadd";

	}
    /**
     * 更新分类页面
     * @return
     */
	public String erjiupdatear() {
		ActionContext.getContext().getValueStack().push(medicineLevelService.getById(model.getId()));
		return "erjiupdatear";

	}
	/**
	 * 更新页面
	 * @return
	 * @throws Exception 
	 */
	public String erjiupdate() throws Exception{
		MedicineLevel entity = medicineLevelService.getById(model.getId());
		if (uploadFileName != null) {
			String pathBase = "/upload/medicineImg/";
			String path = ServletActionContext.getServletContext().getRealPath(
					pathBase);
			File file = new File(path);
			System.out.println("xin"+uploadFileName);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileUtils.copyFile(upload, new File(file, uploadFileName));//
			entity.setLevelImg(pathBase + uploadFileName);
		}
		entity.setName(model.getName());
		entity.setPostion(model.getPostion());
		entity.setRemark(model.getRemark());
		//修改后返回二级列表
		ActionContext.getContext().getValueStack().push(entity.getParentLevel());
		//////
		medicineLevelService.update(entity);
		return "erjiupdate";
	}
	/**
	 * 删除分类
	 * @return
	 */
	public String erjidelete(){
		//删除二级分类后 还回到二级分类列表
		ActionContext.getContext().getValueStack().push(medicineLevelService.getById(model.getId()).getParentLevel());
		//
		medicineLevelService.delete(model.getId());
		return "erjidelete";
		
	}
	
	///////////////////////封装
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
