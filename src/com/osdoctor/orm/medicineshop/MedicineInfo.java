package com.osdoctor.orm.medicineshop;


/**
 * 药品的主类
 * @author javafengyu
 *
 */
public class MedicineInfo {

	private Integer id;
	private String name;//药品名
	private String notice;//添加的备注
	private String medicineId;//药品的编号
	private Float medicinePrice;//药品的推荐价格
	private Float medicineNewPrice;//最新价格
	private String pharmacy;//药房
	private String standard;//规格
	private String medicineWord;//药准字
	private String manufacturer;//厂商
	private String commonName;//通用名称
	private String attending;//功能主治
	private String indication;//适应症
	private String usageAndDosage;//用法用量
	//所属分类
	private MedicineLevel medicineLevel;
	private MedicineDetail medicineDetail;//商品详情
	
	public MedicineInfo(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getMedicineId() {
		return medicineId;
	}


	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public Float getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(Float medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public MedicineLevel getMedicineLevel() {
		return medicineLevel;
	}

	public void setMedicineLevel(MedicineLevel medicineLevel) {
		this.medicineLevel = medicineLevel;
	}

	public MedicineDetail getMedicineDetail() {
		return medicineDetail;
	}

	public void setMedicineDetail(MedicineDetail medicineDetail) {
		this.medicineDetail = medicineDetail;
	}

	public Float getMedicineNewPrice() {
		return medicineNewPrice;
	}

	public void setMedicineNewPrice(Float medicineNewPrice) {
		this.medicineNewPrice = medicineNewPrice;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getMedicineWord() {
		return medicineWord;
	}

	public void setMedicineWord(String medicineWord) {
		this.medicineWord = medicineWord;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getAttending() {
		return attending;
	}

	public void setAttending(String attending) {
		this.attending = attending;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getUsageAndDosage() {
		return usageAndDosage;
	}

	public void setUsageAndDosage(String usageAndDosage) {
		this.usageAndDosage = usageAndDosage;
	}

	
}
