package com.wx.oa.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.service.ForumService;
import com.wx.oa.service.TopicService;

@Controller("forumAction")
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{

	@Resource(name="forumService")
	private ForumService forumService;
	@Resource(name="topicService")
	private TopicService topicService;
	
	// 版块列表
	public String list() {
		
		String hql = "from Forum f order by f.position";
		List<Object> parameters = new ArrayList<Object>();
		PageBean pageBean = forumService.getPageBean(pageNum, pageSize2, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "list";
	}
	
	// 显示单个版块(主题列表)
	public String show() {
		// 准备数据：forum
		Forum forum = forumService.getForumById(getModel().getId());
		ActionContext.getContext().put("forum", forum);
		
		// 准备数据：
		
		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 " +
				"THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(forum);
		PageBean pageBean = topicService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}
}
