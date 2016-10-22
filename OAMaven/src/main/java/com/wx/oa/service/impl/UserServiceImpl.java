package com.wx.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.oa.dao.DepartmentDao;
import com.wx.oa.dao.RoleDao;
import com.wx.oa.dao.UserDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Department;
import com.wx.oa.domain.sysmanage.Role;
import com.wx.oa.domain.sysmanage.User;
import com.wx.oa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;
	@Resource(name = "departmentDao")
	private DepartmentDao departmentDao;
	@Resource(name = "roleDao")
	private RoleDao roleDao;

	public Collection<User> getAllUsers() {
		return userDao.getAllEntry();
	}

	@Transactional(readOnly = false)
	public void saveUser(Long did, Long[] rids, User user) {
		Department department = departmentDao.getEntryById(did);
		Set<Role> roles = (Set<Role>) roleDao.getEntryByIds(rids);
		user.setDepartment(department);
		user.setRoles(roles);
		user.setPassword("666666"); // 新增用户的时候默认的密码
		userDao.saveEntry(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(Serializable id) {
		userDao.deleteEntry(id);
	}

	@Transactional(readOnly = false)
	public void updateUser(Long did, Long[] rids, User user) {
		Department department = departmentDao.getEntryById(did);
		Set<Role> roles = (Set<Role>) roleDao.getEntryByIds(rids);
		user.setDepartment(department);
		user.setRoles(roles);
		userDao.updateEntry(user);
	}

	public User getUserById(Serializable id) {
		return userDao.getEntryById(id);
	}

	public User login(String username, String password) {
		return userDao
				.getEntryByCondition(
						"from User where username=? and password=?", username,
						password);
	}

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return userDao.getPageBean(pageNum, pageSize, hql, parameters);
	}

}
