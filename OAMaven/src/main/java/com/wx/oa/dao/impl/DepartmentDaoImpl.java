package com.wx.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.wx.oa.dao.DepartmentDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {
	
}
