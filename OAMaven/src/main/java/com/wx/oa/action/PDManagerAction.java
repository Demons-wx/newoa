package com.wx.oa.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wx.oa.service.PDManager;

@Controller("pdManagerAction")
@Scope("prototype")
public class PDManagerAction extends ActionSupport{

	@Resource(name="pdManager")
	private PDManager pdManager;
	
	private File resource;
	private String key;
	private String deploymentId;
	private InputStream inputStream;
	
	public String showLastVersions(){
		Collection<ProcessDefinition> processDefinitions = pdManager.getLastVersion();
		ActionContext.getContext().put("pdList", processDefinitions);
		return "pdList";
	}
	
	// 跳转到流程定义的部署页面
	public String deployUI(){
		return "deployUI";
	}
	
	// 部署
	public String deploy() throws Exception{
		pdManager.deploy(resource);
		return "action2action";
	}
	
	// 删除PD
	public String deletePD(){
		pdManager.deletePD(key);
		return "action2action";
	}
	
	// 查看图片
	public String showImage(){
		inputStream = pdManager.showImage(deploymentId);
		return SUCCESS;
	}
	
	public PDManager getPdManager() {
		return pdManager;
	}
	public File getResource() {
		return resource;
	}
	public String getKey() {
		return key;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setPdManager(PDManager pdManager) {
		this.pdManager = pdManager;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
