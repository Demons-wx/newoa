package com.wx.oa.domain.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class Form implements Serializable{

	private Long fid;
	private String title;
	private String applicator;
	private Date applicatetime;
	private String state;
	private String url;
	
	private Set<Approve> approves;
	private String piid; // 流程实例id
	private FormTemplate formTemplate;
	
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApplicator() {
		return applicator;
	}
	public void setApplicator(String applicator) {
		this.applicator = applicator;
	}
	public Date getApplicatetime() {
		return applicatetime;
	}
	public void setApplicatetime(Date applicatetime) {
		this.applicatetime = applicatetime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Approve> getApproves() {
		return approves;
	}
	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public FormTemplate getFormTemplate() {
		return formTemplate;
	}
	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}
	
}
