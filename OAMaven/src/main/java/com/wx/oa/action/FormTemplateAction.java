package com.wx.oa.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.workflow.FormTemplate;
import com.wx.oa.service.FormTemplateService;
import com.wx.oa.service.PDManager;
import com.wx.oa.utils.UploadUtils;

@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate>{
	
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	@Resource(name="pdManager")
	private PDManager pdManager;
	
	private File resource;
	private InputStream inputStream;
	
	public String showAllFormTemplate(){
		Collection<FormTemplate> formTemplates = formTemplateService.getAllFormTemplate();
		ActionContext.getContext().put("ftList", formTemplates);
		return "listAction";
	}
	
	// 跳转到表单模板添加页面
	public String addUI(){
		Collection<ProcessDefinition> processDefinitions = pdManager.getLastVersion();
		ActionContext.getContext().put("pdList", processDefinitions);
		return "addUI";
	}

	// 添加模板
	public String add(){
		String url = UploadUtils.saveUploadFile(resource);
		FormTemplate formTemplate = new FormTemplate();
		BeanUtils.copyProperties(getModel(), formTemplate);
		formTemplate.setUrl(url);
		formTemplateService.saveFormTemplate(formTemplate);
		return action2action;
	}
	
	// 删除模板
	public String delete(){
		formTemplateService.deleteFormTemplate(model.getFtid());
		return action2action;
	}
	
	// 跳转到修改页面
	public String updateUI(){
		FormTemplate formTemplate = formTemplateService.getFormTempLateById(model.getFtid());
		ActionContext.getContext().getValueStack().push(formTemplate);
		Collection<ProcessDefinition> processDefinitions = pdManager.getLastVersion();
		ActionContext.getContext().put("pdList", processDefinitions);
		return updateUI;
	}
	
	// 修改模板
	public String update(){
		FormTemplate formTemplate = formTemplateService.getFormTempLateById(model.getFtid());
		formTemplate.setName(model.getName());
		formTemplate.setProcessKey(model.getProcessKey());
		// 如果模板文件有修改，才会更新
		if(resource != null){
			formTemplate.setUrl(UploadUtils.saveUploadFile(resource));
		}
		formTemplateService.updateFormTemplate(formTemplate);
		return action2action;
	}
	
	
	// 下载模板
	public String download() throws Exception{
		inputStream = formTemplateService.download(getModel().getFtid());
		return "download";
	}

	
	public File getResource() {
		return resource;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
