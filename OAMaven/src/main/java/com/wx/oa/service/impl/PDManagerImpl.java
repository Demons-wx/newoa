package com.wx.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import com.wx.oa.service.PDManager;

@Service("pdManager")
public class PDManagerImpl implements PDManager{

	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	
	public Collection<ProcessDefinition> getLastVersion() {
		// 把所有的流程定义查出来，并且按照版本从低到高排序
		Collection<ProcessDefinition> processDefinitions = processEngine.getRepositoryService()
				.createProcessDefinitionQuery().orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION).list();
		// 遍历每一个流程定义，如果存在相同的key值，后者覆盖前者，也就意味着高版本覆盖低版本
		Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();
		for (ProcessDefinition processDefinition : processDefinitions) {
			map.put(processDefinition.getKey(), processDefinition);
		}
		// values():方法是获取集合中的所有的值----没有键，没有对应关系
		return map.values();
	}

	// 部署
	public void deploy(File resource) throws Exception {
		InputStream inputStream = new FileInputStream(resource);
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		processEngine.getRepositoryService().createDeployment()
		.addResourcesFromZipInputStream(zipInputStream).deploy();
	}

	// 删除流程定义
	public void deletePD(String key) {
		// 根据key获取该key值下面所有流程定义
		List<ProcessDefinition> pdList = processEngine.getRepositoryService()
				.createProcessDefinitionQuery().processDefinitionKey(key).list();
		for (ProcessDefinition processDefinition : pdList) {
			// 根据每一个流程定义获取到deploymentId,然后进行删除
			processEngine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId());
		}
	}

	// 查看图片
	public InputStream showImage(String deploymentId) {
		// 根据deploymentId和图片路径把图片加载出来
		ProcessDefinition processDefinition = processEngine.getRepositoryService()
				.createProcessDefinitionQuery().deploymentId(deploymentId).uniqueResult();
		return processEngine.getRepositoryService().getResourceAsStream(deploymentId, processDefinition.getImageResourceName());
	}

}
