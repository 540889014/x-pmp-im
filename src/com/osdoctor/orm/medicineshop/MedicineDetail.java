package com.osdoctor.orm.medicineshop;



/**
 * 药品的详情 和药品一对一关系
 * @author javafengyu
 *
 */
public class MedicineDetail {

	private Integer id;
	private String content;//商品论述
	private String detailImg;//详情图片
	
	public MedicineDetail(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	
}
