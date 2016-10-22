package com.wx.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.wx.oa.dao.ForumDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.service.ForumService;

@Service("forumService")
public class ForumServiceImpl implements ForumService {

	@Resource(name = "forumDao")
	private ForumDao forumDao;

	public Collection<Forum> getAllForums() {
		return forumDao.getAllForums();
	}

	@Transactional(readOnly = false)
	public void saveForum(Forum forum) {
		forumDao.saveForum(forum);
	}

	@Transactional(readOnly = false)
	public void deleteForum(Serializable id) {
		forumDao.deleteEntry(id);
	}

	@Transactional(readOnly = false)
	public void updateForum(Forum forum) {
		forumDao.updateEntry(forum);
	}

	public Forum getForumById(Serializable id) {
		return forumDao.getEntryById(id);
	}

	public void moveUp(Serializable id) {
		forumDao.moveUp(id);
	}

	public void moveDown(Serializable id) {
		forumDao.moveDown(id);
	}

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return forumDao.getPageBean(pageNum, pageSize, hql, parameters);
	}

}
