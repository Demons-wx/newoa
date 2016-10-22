package com.wx.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.TopicDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Topic;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao{

	@Deprecated
	public List<Topic> findTopicsByForum(Forum forum) {
		return hibernateTemplate.find("FROM Topic t WHERE t.forum=? " +
				"ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, " +
				"t.lastUpdateTime DESC",forum);
	}

	@Deprecated
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum) {
		// 查询本页的数据列表
		List list = hibernateTemplate.getSessionFactory().openSession().createQuery(//
						"FROM Topic t WHERE t.forum=? " +
						"ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, " +
						"t.lastUpdateTime DESC")//
						.setParameter(0, forum)//
						.setFirstResult((pageNum - 1) * pageSize)//
						.setMaxResults(pageSize)//
						.list();
		// 查询总记录数
		Long count = (Long) hibernateTemplate.find("SELECT COUNT(*) FROM Topic t WHERE t.forum=? ",forum).get(0);
		
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
	
}
