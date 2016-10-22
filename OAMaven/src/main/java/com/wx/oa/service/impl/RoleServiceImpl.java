package com.wx.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.oa.dao.RoleDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Role;
import com.wx.oa.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleDao")
	private RoleDao roleDao;

	public Collection<Role> getAllRoles() {
		return roleDao.getAllEntry();
	}

	@Transactional(readOnly = false)
	public void saveRole(Role role) {
		roleDao.saveEntry(role);
	}

	@Transactional(readOnly = false)
	public void deleteRole(Serializable id) {
		roleDao.deleteEntry(id);
	}

	@Transactional(readOnly = false)
	public void updateRole(Role role) {
		roleDao.updateEntry(role);
	}

	public Role getRoleById(Serializable id) {
		return roleDao.getEntryById(id);
	}

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return roleDao.getPageBean(pageNum, pageSize, hql, parameters);
	}

}
