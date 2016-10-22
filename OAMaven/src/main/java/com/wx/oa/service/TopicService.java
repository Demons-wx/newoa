package com.wx.oa.service;

import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Topic;

public interface TopicService {

	/**
	 * 查询指定版块中的所有主题，
	 * 排序：所有置顶帖在最上面，并按最后更新时间排序，让新状态在上面。
	 * @param forum
	 * @return
	 */
	@Deprecated
	public List<Topic> findTopicsByForum(Forum forum);
	@Deprecated
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum);
	
	public void saveTopic(Topic topic);
	public Topic getTopicById(Long id);
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);
}
