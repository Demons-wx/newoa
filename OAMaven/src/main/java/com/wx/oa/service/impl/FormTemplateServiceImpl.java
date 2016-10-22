package com.wx.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.dao.FormTemplateDao;
import com.wx.oa.domain.workflow.FormTemplate;
import com.wx.oa.service.FormTemplateService;

@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService{

	@Resource(name="formTemplateDao")
	private FormTemplateDao formTemplateDao;
	
	public Collection<FormTemplate> getAllFormTemplate() {
		return formTemplateDao.getAllEntry();
	}

	@Transactional(readOnly=false)
	public void saveFormTemplate(FormTemplate formTemplate) {
		formTemplateDao.saveEntry(formTemplate);
	}

	public InputStream download(Long ftid) throws Exception {
		FormTemplate formTemplate = formTemplateDao.getEntryById(ftid);
		String url = formTemplate.getUrl();
		String fileName = formTemplate.getName();
		fileName = URLEncoder.encode(fileName, "utf-8");
		ActionContext.getContext().put("fileName", fileName);
		return new FileInputStream(new File(url));
	}

	@Transactional(readOnly=false)
	public void deleteFormTemplate(Long ftid) {
		formTemplateDao.deleteEntry(ftid);
	}

	public FormTemplate getFormTempLateById(Long ftid) {
		return formTemplateDao.getEntryById(ftid);
	}

	@Transactional(readOnly=false)
	public void updateFormTemplate(FormTemplate formTemplate) {
		formTemplateDao.updateEntry(formTemplate);
	}

}
