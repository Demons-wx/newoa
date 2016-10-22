package com.wx.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;

public interface ForumService {

	// 所有版块
	public Collection<Forum> getAllForums();

	// 保存
	public void saveForum(Forum Forum);

	// 删除
	public void deleteForum(Serializable id);

	// 修改
	public void updateForum(Forum Forum);

	// 根据id拿
	public Forum getForumById(Serializable id);

	// 上移
	public void moveUp(Serializable id);

	// 下移
	public void moveDown(Serializable id);

	// 分页
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);
}
