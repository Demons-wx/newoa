package com.wx.oa.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.FormDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.workflow.Form;

@Repository("formDao")
public class FormDaoImpl extends BaseDaoImpl<Form> implements FormDao{

	public Collection<Form> getFormsByApplicator(String applicator) {
		return hibernateTemplate.find("FROM Form where applicator=?", applicator);
	}

}
