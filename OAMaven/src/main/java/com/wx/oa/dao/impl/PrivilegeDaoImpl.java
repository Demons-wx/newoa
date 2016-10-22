package com.wx.oa.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wx.oa.dao.PrivilegeDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.sysmanage.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeDao {

	@Resource(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	public List<Privilege> findTopList() {
		return hibernateTemplate
				.find("from Privilege p where p.parent is null");
	}

	public Collection<String> getAllPrivilegeUrls() {
		return hibernateTemplate
				.find("SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL");
	}

}
