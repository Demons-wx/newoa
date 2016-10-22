package com.wx.oa.domain.workflow;

import java.io.Serializable;
import java.util.Set;

/**
 * 表单模板
 * @author Demons
 *
 */
public class FormTemplate implements Serializable{

	private Long ftid;
	private String name;
	private String processKey; // 模板所用的流程
	private String url;
	
	private Set<Form> forms;

	public Long getFtid() {
		return ftid;
	}

	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
	
}
