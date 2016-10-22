package com.wx.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.jbpm.api.ProcessDefinition;

/**
 * 流程定义管理
 * @author Demons
 *
 */
public interface PDManager {
	public Collection<ProcessDefinition> getLastVersion();
	public void deploy(File resource) throws Exception;
	public void deletePD(String key);
	public InputStream showImage(String deploymentId);
}
