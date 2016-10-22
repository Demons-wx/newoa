package com.wx.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.oa.dao.DepartmentDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Department;
import com.wx.oa.service.DepartmentService;
import javax.annotation.Resource;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource(name = "departmentDao")
	private DepartmentDao departmentDao;

	public Collection<Department> getAllDepartments() {
		return departmentDao.getAllEntry();
	}

	@Transactional(readOnly = false)
	public void saveDepartment(Department department) {
		departmentDao.saveEntry(department);
	}

	@Transactional(readOnly = false)
	public void deleteDepartment(Serializable id) {
		departmentDao.deleteEntry(id);
	}

	@Transactional(readOnly = false)
	public void updateDepartment(Department department) {
		departmentDao.updateEntry(department);
	}

	public Department getDepartmentById(Serializable id) {
		return departmentDao.getEntryById(id);
	}

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return departmentDao.getPageBean(pageNum, pageSize, hql, parameters);
	}

}
