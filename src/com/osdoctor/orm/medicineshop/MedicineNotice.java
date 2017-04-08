package com.osdoctor.orm.medicineshop;


/**
 * 药品商城出的公告栏
 * @author javafengyu
 *
 */
public class MedicineNotice {

	private Integer id;
	private String title;//公告标题
	private String noticeImg;//详情图片
	private String content;//长文本
	private String type;//指定广告的类型，是药品？还是一场活动？暂时只考虑药品medicine
	private String infoId;//指向信息的Id,如果type是medicine这里就是药品信息的Id ,     
	private int postion;//位置
	private boolean view=false;//是否显示
	public MedicineNotice(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNoticeImg() {
		return noticeImg;
	}
	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostion() {
		return postion;
	}
	public void setPostion(int postion) {
		this.postion = postion;
	}
	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
}
