package com.osdoctor.action.medicineshop;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.osdoctor.action.BaseAction;
import com.osdoctor.orm.medicineshop.MedicineDetail;
import com.osdoctor.orm.medicineshop.MedicineInfo;
import com.osdoctor.orm.medicineshop.MedicineLevel;
import com.osdoctor.util.HqlHelper;

public class Manager_MedicineInfoAction extends BaseAction<MedicineInfo>{
	protected File upload;// 对应 页面 input name名
	protected String uploadFileName;// 上传文件的名字
	protected String uploadContentType;// 上传文件的类型
	private MedicineDetail detail;// 商品详情
	private String content;
	private Integer medicineLevelId;// 商品分类ID

	/**
	 * 药品列表
	 * 
	 * @return
	 */
	public String list() {
		ActionContext
				.getContext()
				.getValueStack()
				.push(medicineLevelService.getPageBean(new HqlHelper(
						MedicineInfo.class, "m"), 1, 10));
		return "list";

	}

	/**
	 * 添加药品页面
	 * 
	 * @return
	 */
	public String addar() {
		// 先把所有二级分类传到前台
		List<MedicineLevel> levels = medicineLevelService
				.findObjects(new HqlHelper(MedicineLevel.class, "m")
						.addWhereCondition("m.parentLevel.id!=null"));
		ActionContext.getContext().put("levels", levels);
		return "addar";

	}

	/**
	 * 添加药品
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		MedicineLevel medicineLevel = medicineLevelService
				.getById(medicineLevelId);// 二级分类
		// 上传图片
		String pathBase = "/upload/medicineImg/";
		String path = ServletActionContext.getServletContext().getRealPath(
				pathBase);
		File file = new File(path);
		System.out.println(uploadFileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		detail.setDetailImg(pathBase + uploadFileName);
		medicineDetailService.save(detail);
		model.setMedicineDetail(detail);
		model.setMedicineLevel(medicineLevel);
		medicineInfoService.save(model);
		return "add";

	}

	/**
	 * 更新药品页面
	 * 
	 * @return
	 */
	public String updatear() {
		// 先把所有二级分类传到前台
		List<MedicineLevel> levels = medicineLevelService
				.findObjects(new HqlHelper(MedicineLevel.class, "m")
						.addWhereCondition("m.parentLevel.id!=null"));
		ActionContext.getContext().put("levels", levels);
		MedicineInfo info =medicineInfoService.getById(model.getId());
		if(info.getMedicineLevel()!=null)
		medicineLevelId = info.getMedicineLevel().getId();
		ActionContext.getContext().getValueStack()
				.push(info);
		return "updatear";

	}

	/**
	 * 更新药品
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String update() throws IOException {
		MedicineInfo  entity = medicineInfoService.getById(model.getId());
		MedicineLevel level = medicineLevelService.getById(medicineLevelId);
		if (uploadFileName != null) {
			String pathBase = "/upload/medicineImg/";
			String path = ServletActionContext.getServletContext().getRealPath(
					pathBase);
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileUtils.copyFile(upload, new File(file, uploadFileName));//
			entity.getMedicineDetail().setDetailImg(pathBase + uploadFileName);
		}
		entity.getMedicineDetail().setContent(content);
		entity.setName(model.getName());
		entity.setNotice(model.getNotice());
		entity.setMedicineId(model.getMedicineId());
		entity.setMedicinePrice(model.getMedicinePrice());
		entity.setMedicineNewPrice(model.getMedicineNewPrice());
		entity.setStandard(model.getStandard());
		entity.setMedicineWord(model.getMedicineWord());
		entity.setManufacturer(model.getManufacturer());
		entity.setCommonName(model.getCommonName());
		entity.setAttending(model.getAttending());
		entity.setIndication(model.getIndication());
		entity.setUsageAndDosage(model.getUsageAndDosage());
		entity.setPharmacy(model.getPharmacy());
		entity.setMedicineLevel(level);
		medicineInfoService.update(entity);
		return "update";

	}

	/**
	 * 删除药品
	 * 
	 * @return
	 */
	public String delete() {
		medicineInfoService.delete(model.getId());
		return "delete";

	}

	/**
	 * ' 药品信息
	 * 
	 * @return
	 */
	public String detail() {
		ActionContext.getContext().getValueStack()
				.push(medicineInfoService.getById(model.getId()));
		return "detail";

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

	public Integer getMedicineLevelId() {
		return medicineLevelId;
	}

	public void setMedicineLevelId(Integer medicineLevelId) {
		this.medicineLevelId = medicineLevelId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MedicineDetail getDetail() {
		return detail;
	}

	public void setDetail(MedicineDetail detail) {
		this.detail = detail;
	}

	
}
