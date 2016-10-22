package com.wx.oa.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport {

	private String method;

	public String forward() {
		return method;
	}

	// ---------------------------
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
