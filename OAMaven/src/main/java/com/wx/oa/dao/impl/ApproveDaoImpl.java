package com.wx.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.ApproveDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.workflow.Approve;

@Repository("approveDao")
public class ApproveDaoImpl extends BaseDaoImpl<Approve> implements ApproveDao{

}
