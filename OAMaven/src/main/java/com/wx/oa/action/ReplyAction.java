package com.wx.oa.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.forummanage.Reply;
import com.wx.oa.domain.forummanage.Topic;
import com.wx.oa.service.ReplyService;
import com.wx.oa.service.TopicService;

@Controller("replyAction")
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{

	private Long topicId;
	
	@Resource(name="topicService")
	private TopicService topicService;
	@Resource(name="replyService")
	private ReplyService replyService;
	
	// 发表新回复页面
	public String addUI() {
		Topic topic = topicService.getTopicById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}
	
	// 发表新回复
	public String add() {
		Reply reply = new Reply();
		
		reply.setTitle(getModel().getTitle());
		reply.setContent(getModel().getContent());
		reply.setTopic(topicService.getTopicById(topicId));
		
		reply.setAuthor(getCurrentUser());
		reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		reply.setPostTime(new Date());
		
		replyService.saveReply(reply);
		return "toTopicShow";
	}

	//----------------------------------------
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
