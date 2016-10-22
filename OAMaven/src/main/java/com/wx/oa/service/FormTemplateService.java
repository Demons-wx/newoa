package com.wx.oa.service;

import java.io.InputStream;
import java.util.Collection;

import com.wx.oa.domain.workflow.FormTemplate;

public interface FormTemplateService {
	
	public Collection<FormTemplate> getAllFormTemplate();
	public void saveFormTemplate(FormTemplate formTemplate);
	public void updateFormTemplate(FormTemplate formTemplate);
	public FormTemplate getFormTempLateById(Long ftid);
	public void deleteFormTemplate(Long ftid);
	public InputStream download(Long ftid) throws Exception;
}
