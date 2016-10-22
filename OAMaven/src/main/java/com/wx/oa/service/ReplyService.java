package com.wx.oa.service;

import java.util.List;

import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Reply;
import com.wx.oa.domain.forummanage.Topic;

public interface ReplyService {
	
	public void saveReply(Reply reply);
	
	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters);

}
