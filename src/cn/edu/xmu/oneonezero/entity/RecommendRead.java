package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RecommendRead")
public class RecommendRead {
	private long id;
	private String name;
	private String content;
	private String picUrl;//加一个编写时间
	private String onShowTime;
	private String offShowTime;
	private String rank;
	private String collector;//采编
	private String chiefEditor;//主编
	private boolean isExamined;//是否审核
	private boolean isPassed;//是否审核通过
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getOnShowTime() {
		return onShowTime;
	}
	public void setOnShowTime(String onShowTime) {
		this.onShowTime = onShowTime;
	}
	public String getOffShowTime() {
		return offShowTime;
	}
	public void setOffShowTime(String offShowTime) {
		this.offShowTime = offShowTime;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCollector() {
		return collector;
	}
	public void setCollector(String collector) {
		this.collector = collector;
	}
	public String getChiefEditor() {
		return chiefEditor;
	}
	public void setChiefEditor(String chiefEditor) {
		this.chiefEditor = chiefEditor;
	}
	
	
	public boolean getIsExamined() {
		return isExamined;
	}
	public void setIsExamined(boolean isExamined) {
		this.isExamined = isExamined;
	}
	public boolean getIsPassed() {
		return isPassed;
	}
	public void setIsPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
	
	
	
}
