package com.wx.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Department;

public interface DepartmentService {

	// 所有部门
	public Collection<Department> getAllDepartments();

	// 保存
	public void saveDepartment(Department department);

	// 删除
	public void deleteDepartment(Serializable id);

	// 修改
	public void updateDepartment(Department department);

	// 根据id拿
	public Department getDepartmentById(Serializable id);

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);

}
