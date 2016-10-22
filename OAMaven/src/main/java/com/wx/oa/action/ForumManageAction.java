package com.wx.oa.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Forum;
import com.wx.oa.service.ForumService;

@Controller("forumManageAction")
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	@Resource(name = "forumService")
	private ForumService forumService;

	// 显示所有版块
	public String showAllForums() {
		
		String hql = "from Forum f order by f.position";
		List<Object> parameters = new ArrayList<Object>();
		PageBean pageBean = forumService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		return listAction;
	}

	// 跳转到增加页面
	public String addUI() {
		return addUI;
	}

	// 增加版块
	public String add() {
		Forum forum = new Forum();
		BeanUtils.copyProperties(getModel(), forum);
		forumService.saveForum(forum);
		return action2action;
	}

	// 跳转到修改页面
	public String updateUI() {
		Forum forum = forumService.getForumById(getModel().getId());
		ActionContext.getContext().getValueStack().push(forum);
		return updateUI;
	}

	// 修改
	public String update() {
		Forum forum = forumService.getForumById(getModel().getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumService.updateForum(forum);
		return action2action;
	}

	// 删除
	public String delete() {
		forumService.deleteForum(getModel().getId());
		return action2action;
	}

	// 上移
	public String moveUp() {
		forumService.moveUp(getModel().getId());
		return action2action;
	}

	// 下移
	public String moveDown() {
		forumService.moveDown(getModel().getId());
		return action2action;
	}
}
