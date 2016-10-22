package com.wx.oa.dao;

import java.util.Collection;
import java.util.List;

import com.wx.oa.dao.base.BaseDao;
import com.wx.oa.domain.sysmanage.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {

	public List<Privilege> findTopList();

	public Collection<String> getAllPrivilegeUrls();
}
