package com.osdoctor.action.medicineshop;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineNotice;
import com.osdoctor.util.HqlHelper;
/**
 * 商城广告
 *
 */
public class Manager_MedicineNoticeAction extends BaseAction<MedicineNotice>{
	protected File upload;// 对应 页面 input name名
	protected String uploadFileName;// 上传文件的名字
	protected String uploadContentType;// 上传文件的类型
	protected String result;

	/**
	 * 公告列表
	 * 
	 * @return
	 */
	public String list() {
		ActionContext
				.getContext()
				.getValueStack()
				.push(medicineNoticeService.getPageBean(new HqlHelper(
						MedicineNotice.class, "m"), 1, 10));
		return "list";
	}

	/**
	 * 转到公告添加页面
	 * 
	 * @return
	 */
	public String addar() {
		return "addar";
	}

	/**
	 * 添加公告
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		String pathBase = "/upload/medicineImg/";
		String path = ServletActionContext.getServletContext().getRealPath(
				pathBase);
		File file = new File(path);
		System.out.println(uploadFileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));//
		model.setNoticeImg(pathBase + uploadFileName);
		medicineNoticeService.save(model);
		return "add";
	}

	/**
	 * 公告更新页面
	 * 
	 * @return
	 */
	public String updatear() {
		ActionContext.getContext().getValueStack().push(medicineNoticeService.getById(model.getId()));
		return "updatear";
	}

	/**
	 * 更新公告
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String update() throws Exception {
		MedicineNotice entity = medicineNoticeService.getById(model.getId());
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
			entity.setNoticeImg(pathBase + uploadFileName);
		}
		entity.setContent(model.getContent());
		entity.setTitle(model.getTitle());
		entity.setView(model.isView());
		medicineNoticeService.update(entity);
		return "update";
	}

	public String delete() {
		medicineNoticeService.delete(model.getId());
		return "delete";

	}

	// //////////////////////封装
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
