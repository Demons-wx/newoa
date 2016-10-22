package com.wx.oa.dao;

import java.util.Collection;

import com.wx.oa.dao.base.BaseDao;
import com.wx.oa.domain.workflow.Form;

public interface FormDao extends BaseDao<Form>{

	Collection<Form> getFormsByApplicator(String applicator);

	
}
