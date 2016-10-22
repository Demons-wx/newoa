package com.wx.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.User;

public interface UserService {

	// 所有用户
	public Collection<User> getAllUsers();

	// 保存
	public void saveUser(Long did, Long[] rids, User user);

	// 删除
	public void deleteUser(Serializable id);

	// 修改
	public void updateUser(Long did, Long[] rids, User user);

	// 根据id拿
	public User getUserById(Serializable id);

	// 登录
	public User login(String username, String password);

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);
}
