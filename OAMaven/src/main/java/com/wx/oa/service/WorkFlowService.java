package com.wx.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.jbpm.api.ProcessInstance;

import com.wx.oa.domain.workflow.Form;

public interface WorkFlowService {
	public ProcessInstance submit(File resource, Long ftid, String processKey);
	public Collection<Form> myTaskList();
	public void approve(Long fid, String result);
	public InputStream download(Long fid) throws Exception;
	public Collection<Form> getFormsByApplicator(String applicator);
}
