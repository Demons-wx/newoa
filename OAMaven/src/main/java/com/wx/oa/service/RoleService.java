package com.wx.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Role;

public interface RoleService {

	// 拿所有岗位
	public Collection<Role> getAllRoles();

	// 保存
	public void saveRole(Role role);

	// 删除
	public void deleteRole(Serializable id);

	// 修改
	public void updateRole(Role role);

	// 根据id拿
	public Role getRoleById(Serializable id);

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);
}
