package com.wx.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.FormTemplateDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.workflow.FormTemplate;

@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends BaseDaoImpl<FormTemplate> implements FormTemplateDao{

}
