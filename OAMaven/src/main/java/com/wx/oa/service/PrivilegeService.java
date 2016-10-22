package com.wx.oa.service;

import java.util.Collection;
import java.util.List;

import com.wx.oa.domain.sysmanage.Privilege;

public interface PrivilegeService {

	// 拿所有权限
	public Collection<String> getAllPrivilegeUrls();

	// 通过ids拿权限
	public Collection<Privilege> getPrivilegeByIds(Long[] privilegeIds);

	// 查询顶级权限
	List<Privilege> findTopList();

}
