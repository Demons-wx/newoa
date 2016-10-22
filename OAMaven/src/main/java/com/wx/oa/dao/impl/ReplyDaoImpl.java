package com.wx.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.ReplyDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.forummanage.Reply;
import com.wx.oa.domain.forummanage.Topic;

@Repository("replyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao{

}
