package com.wx.oa.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.wx.oa.dao.PrivilegeDao;
import com.wx.oa.domain.sysmanage.Privilege;
import com.wx.oa.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource(name = "privilegeDao")
	private PrivilegeDao privilegeDao;

	public Collection<String> getAllPrivilegeUrls() {
		return privilegeDao.getAllPrivilegeUrls();
	}

	public Collection<Privilege> getPrivilegeByIds(Long[] privilegeIds) {
		return privilegeDao.getEntryByIds(privilegeIds);
	}

	public List<Privilege> findTopList() {
		return privilegeDao.findTopList();
	}

}
