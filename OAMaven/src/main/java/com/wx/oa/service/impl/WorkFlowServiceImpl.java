package com.wx.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.dao.ApproveDao;
import com.wx.oa.dao.FormDao;
import com.wx.oa.dao.FormTemplateDao;
import com.wx.oa.domain.sysmanage.User;
import com.wx.oa.domain.workflow.Approve;
import com.wx.oa.domain.workflow.Form;
import com.wx.oa.domain.workflow.FormTemplate;
import com.wx.oa.service.WorkFlowService;
import com.wx.oa.utils.UploadUtils;

@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService{

	@Resource(name="formTemplateDao")
	private FormTemplateDao formTemplateDao;
	@Resource(name="formDao")
	private FormDao formDao;
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	@Resource(name="approveDao")
	private ApproveDao approveDao;
	
	@Transactional(readOnly=false)
	public ProcessInstance submit(File resource, Long ftid, String processKey) {
		// 完成文件上传
		String url = UploadUtils.saveUploadFile(resource);
		
		// 填充form对象
		Form form = new Form();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		form.setApplicator(user.getUsername());
		Date time = new Date();
		form.setApplicatetime(time);
		FormTemplate formTemplate = formTemplateDao.getEntryById(ftid);
		form.setFormTemplate(formTemplate);
		form.setState("审批中");
		form.setTitle(user.getUsername()+"_"+formTemplate.getName()+"_"+time);
		form.setUrl(url);
		formDao.saveEntry(form);
		
		// 启动流程实例
		Map<String, Form> variables = new HashMap<String, Form>();
		variables.put("form", form);
		ProcessInstance processInstance = processEngine.getExecutionService().startProcessInstanceByKey(processKey, variables);
		form.setPiid(processInstance.getId());
		
		return processInstance;
	}

	// 根据当前登录人查询出正在执行的任务
	public Collection<Form> myTaskList() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		String username = user.getUsername();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery()
				.assignee(username).list();
		Collection<Form> forms = new ArrayList<Form>();
		for (Task task : tasks) {
			// 根据流程实例id和流程变量key，拿到流程变量
			Form form = (Form) processEngine.getExecutionService().getVariable(task.getExecutionId(), "form");
			forms.add(form);
		}
		return forms;
	}

	@Transactional(readOnly=false)
	public void approve(Long fid, String result) {
		Form form = formDao.getEntryById(fid);
		String piid = form.getPiid();
		Task task = processEngine.getTaskService().createTaskQuery().executionId(piid).uniqueResult();
		String taskid = task.getId();
		Boolean isapprove = false;
		if("同意".equals(result)){
			processEngine.getTaskService().completeTask(taskid);
			if(processEngine.getExecutionService().createProcessInstanceQuery().processInstanceId(piid).uniqueResult().isEnded()){
				form.setState("申请成功");
				formDao.updateEntry(form);
				isapprove = true;
			}
		}else{
			processEngine.getExecutionService().endProcessInstance(piid, "failed");
			form.setState("申请被拒绝");
			formDao.updateEntry(form);
		}
		
		Approve approve = new Approve();
		approve.setApprovename(task.getAssignee());
		approve.setIsapprove(isapprove);
		approve.setForm(form);
		approveDao.saveEntry(approve);
	}

	public InputStream download(Long fid) throws Exception {
		Form form = formDao.getEntryById(fid);
		String url = form.getUrl();
		String fileName = form.getTitle();
		fileName = URLEncoder.encode(fileName, "utf-8");
		ActionContext.getContext().put("fileName", fileName);
		return new FileInputStream(new File(url));
	}

	public Collection<Form> getFormsByApplicator(String applicator) {
		return formDao.getFormsByApplicator(applicator);
	}
}
