package com.osdoctor.action;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osdoctor.service.medicineshop.MedicineDayRecommendService;
import com.osdoctor.service.medicineshop.MedicineDetailService;
import com.osdoctor.service.medicineshop.MedicineInfoService;
import com.osdoctor.service.medicineshop.MedicineLevelService;
import com.osdoctor.service.medicineshop.MedicineNoticeService;
import com.osdoctor.service.medicineshop.impl.MedicineDayRecommendServiceImpl;
import com.osdoctor.service.osOperaor.OsControlService;
import com.osdoctor.service.osOperaor.OsPatientService;
import com.osdoctor.service.topiccommon.TopicLabelService;
import com.osdoctor.service.topiccontrol.ControlSectionService;
import com.osdoctor.service.topiccontrol.ControlTopicPhotoService;
import com.osdoctor.service.topiccontrol.ControlTopicService;
import com.osdoctor.service.topiccontrol.DoctorOrPatientReplyService;
import com.osdoctor.service.topicdoctormine.DoctorMineTopicService;
import com.osdoctor.service.topicdoctormine.PatientMineReplyService;
import com.osdoctor.service.topicpatient.PatientReplyService;
import com.osdoctor.service.topicpatient.PatientSectionService;
import com.osdoctor.service.topicpatient.PatientTopicService;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {


	protected T model;
	
	
	@Resource
	protected MedicineDetailService medicineDetailService;
	@Resource
	protected MedicineInfoService medicineInfoService;
	@Resource
	protected MedicineLevelService medicineLevelService;
	@Resource
	protected MedicineNoticeService medicineNoticeService;
    @Resource
    protected MedicineDayRecommendService  medicineDayRecommendService;
    @Resource
    protected OsPatientService osPatientService;
    @Resource
    protected PatientReplyService patientReplyService;
    @Resource
    protected PatientSectionService patientSectionService;
    @Resource
    protected PatientTopicService patientTopicService;
    @Resource
    protected OsControlService osControlService;
    @Resource
    protected DoctorMineTopicService doctorMineTopicService;
    @Resource
    protected PatientMineReplyService patientMineReplyService;
    @Resource
    protected TopicLabelService topicLabelService;
    @Resource
    protected ControlTopicService controlTopicService;
    @Resource
    protected ControlTopicPhotoService controlTopicPhotoService;
    @Resource
    protected ControlSectionService controlSectionService;
    @Resource
    protected DoctorOrPatientReplyService doctorOrPatientReplyService;
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];

			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
}
