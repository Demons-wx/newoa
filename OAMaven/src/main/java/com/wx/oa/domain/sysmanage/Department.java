package com.wx.oa.domain.sysmanage;

import java.io.Serializable;

public class Department implements Serializable {

	private Long did;
	private String name;
	private String description;
	private String pd; // 上级部门

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPd() {
		return pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

}
