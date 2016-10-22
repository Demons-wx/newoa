package com.wx.oa.dao;

import java.util.List;

import com.wx.oa.dao.base.BaseDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Topic;

public interface TopicDao extends BaseDao<Topic>{
	/**
	 * 根据forum获取它的topic
	 * @param forum
	 * @return
	 */
	@Deprecated
	public List<Topic> findTopicsByForum(Forum forum);
	@Deprecated
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum);
}
