package com.osdoctor.util.copy;

import java.util.ArrayList;
import java.util.List;

public class ScoreBean {

	private String id;
	private String factor;
	private String num;
	private String weight;
	private String score;
	private String riskfeature;
	private String memo;
	private String type;
	private String levels;
	private List<ScoreBean> children;
	private String fuid;
	// Constructors


	public List<ScoreBean> getChildren() {
		return children;
	}

	public void setChildren(List<ScoreBean> alllist) {
		children = new ArrayList<ScoreBean>();
		ScoreBean treebean;
		for(int i=0;i<alllist.size();i++){
			treebean = alllist.get(i);
			if(treebean.getFuid() != null && !treebean.getFuid().equals("") && !treebean.getFuid().equals("0") && treebean.getFuid().equals(id)){
				children.add(treebean);
				treebean.setChildren(alllist);
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRiskfeature() {
		return riskfeature;
	}

	public void setRiskfeature(String riskfeature) {
		this.riskfeature = riskfeature;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

}
