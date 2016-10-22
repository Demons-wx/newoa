package com.wx.oa.dao;

import java.io.Serializable;
import java.util.List;

import com.wx.oa.dao.base.BaseDao;
import com.wx.oa.domain.forummanage.Forum;

public interface ForumDao extends BaseDao<Forum> {

	public List<Forum> getAllForums();

	public void saveForum(Forum forum);

	public void moveUp(Serializable id);

	public void moveDown(Serializable id);
}
