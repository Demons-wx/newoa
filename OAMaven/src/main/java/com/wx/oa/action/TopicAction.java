package com.wx.oa.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.domain.forummanage.Reply;
import com.wx.oa.domain.forummanage.Topic;
import com.wx.oa.service.ForumService;
import com.wx.oa.service.ReplyService;
import com.wx.oa.service.TopicService;


@Controller("topicAction")
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{

	private Long forumId;
	
	
	@Resource(name="forumService")
	private ForumService forumService;
	@Resource(name="topicService")
	private TopicService topicService;
	@Resource(name="replyService")
	private ReplyService replyService;
	
	// 显示单个主题(主帖+回帖列表)
	public String show() {
		
		// 准备数据：topic
		Topic topic = topicService.getTopicById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
		// 准备数据：replyList
	//	List<Reply> replyList = replyService.findReplysByTopic(topic);
	// 	ActionContext.getContext().put("replyList", replyList);
		
		// 准备分页信息
		/*PageBean pageBean = replyService.getPageBeanByTopic(pageNum, pageSize, topic);
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
		String hql = "FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(topic);
		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "show";
	}
	
	// 发表新主题页面
	public String addUI() {
		Forum forum = forumService.getForumById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	// 发表新主题
	public String add() {
		// 封装参数
		Topic topic = new Topic();
		// 1. 表单提交的数据
		topic.setTitle(getModel().getTitle());
		topic.setContent(getModel().getContent());
		topic.setForum(forumService.getForumById(forumId));
		// 2. 当前直接获取的信息
		topic.setAuthor(getCurrentUser()); // 当前登录的用户
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr()); // 获取当前请求ip
		topic.setPostTime(new Date()); // 当前时间
		topicService.saveTopic(topic);
		
		ActionContext.getContext().put("topic", topic);
		return "show";
	}
	
	//----------------------------------

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	
	
}
