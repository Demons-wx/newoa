package com.wx.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.wx.oa.dao.ForumDao;
import com.wx.oa.dao.TopicDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Topic;
import com.wx.oa.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService{

	@Resource(name="topicDao")
	private TopicDao topicDao;
	@Resource(name = "forumDao")
	private ForumDao forumDao;
	
	@Deprecated
	public List<Topic> findTopicsByForum(Forum forum) {
		return topicDao.findTopicsByForum(forum);
	}

	@Transactional(readOnly = false)
	public void saveTopic(Topic topic){
		// 1. 保存自己的属性
		topic.setType(topic.TYPE_NORMAL);  // 普通帖 默认
		topic.setReplyCount(0);
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
		topicDao.saveEntry(topic);
		// 2. 维护相关的属性
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1); // 主题数量
		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量（主题数+回复数）
		forum.setLastTopic(topic); // 最后发表的主题
		forumDao.saveEntry(forum);
	}

	public Topic getTopicById(Long id) {
		return topicDao.getEntryById(id);
	}
	
	@Deprecated
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum) {
		return topicDao.getPageBeanByForum(pageNum, pageSize, forum);
	}

	
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return topicDao.getPageBean(pageNum, pageSize, hql, parameters);
	}
}
