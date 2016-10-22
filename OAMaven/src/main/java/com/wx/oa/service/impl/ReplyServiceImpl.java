package com.wx.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.oa.dao.ForumDao;
import com.wx.oa.dao.ReplyDao;
import com.wx.oa.dao.TopicDao;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Reply;
import com.wx.oa.domain.forummanage.Topic;
import com.wx.oa.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{

	@Resource(name="replyDao")
	private ReplyDao replyDao;
	@Resource(name="topicDao")
	private TopicDao topicDao;
	@Resource(name="forumDao")
	private ForumDao forumDao;
	
	@Transactional(readOnly = false)
	public void saveReply(Reply reply) {
		// 1. 保存
		replyDao.saveEntry(reply);
		// 2. 维护相关属性
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		
		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量
		topic.setReplyCount(topic.getReplyCount() + 1); // 回复数量
		topic.setLastReply(reply); // 最后发表的回复
		topic.setLastUpdateTime(reply.getPostTime()); // 最后更新时间
		
		topicDao.updateEntry(topic);
		forumDao.updateEntry(forum);
	}
	
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		return replyDao.getPageBean(pageNum, pageSize, hql, parameters);
	}

}
