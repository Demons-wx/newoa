package com.wx.oa.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wx.oa.domain.sysmanage.User;
import com.wx.oa.domain.workflow.Form;
import com.wx.oa.domain.workflow.FormTemplate;
import com.wx.oa.service.FormTemplateService;
import com.wx.oa.service.WorkFlowService;

@Controller("workFlowAction")
@Scope("prototype")
public class WorkFlowAction extends ActionSupport{

	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	@Resource(name="workFlowService")
	private WorkFlowService workFlowService;
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	
	private File resource;
	private Long ftid;
	private String processKey;
	private ProcessInstance processInstance;
	private Long fid;
	private String result;
	private InputStream inputStream;
	
	// 跳转到表单模板的列表页面
	public String showFormTemplate(){
		Collection<FormTemplate> ftList = formTemplateService.getAllFormTemplate();
		ActionContext.getContext().put("ftList", ftList);
		return "formTemplateList";
	}
	
	// 跳转到提交申请页面
	public String submitUI(){
		return "submitUI";
	}
	
	// 提交申请
	public String submit(){
		processInstance = workFlowService.submit(resource, ftid, processKey);
		
		// 完成任务
		Task task = processEngine.getTaskService().createTaskQuery()
				.executionId(processInstance.getId()).uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());
		
		// 跳转到我的申请记录页面
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Collection<Form> forms = workFlowService.getFormsByApplicator(user.getUsername());
		ActionContext.getContext().put("forms", forms);
		return "applyUI";
	}
	
	// 登录人需要处理的申请
	public String showMyTaskList(){
		Collection<Form> forms = workFlowService.myTaskList();
		ActionContext.getContext().put("forms", forms);
		return "myTaskList";
	}
	
	// 审批处理UI
	public String takeTaskUI(){
		ActionContext.getContext().put("fid", fid);
		return "approveUI";
	}
	
	// 处理
	public String approve(){
		workFlowService.approve(fid, result);
		return SUCCESS;
	}
	
	// 下载申请信息
	public String download() throws Exception{
		inputStream = workFlowService.download(fid);
		return "download";
	}
	
	// 我的申请UI
	public String myApplyUI(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Collection<Form> forms = workFlowService.getFormsByApplicator(user.getUsername());
		ActionContext.getContext().put("forms", forms);
		return "applyUI";
	}
	
	public File getResource() {
		return resource;
	}
	public Long getFtid() {
		return ftid;
	}
	public String getProcessKey() {
		return processKey;
	}
	public ProcessInstance getProcessInstance() {
		return processInstance;
	}
	public Long getFid() {
		return fid;
	}
	public String getResult() {
		return result;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}
	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
