package com.wx.oa.dao.impl;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import com.wx.oa.dao.UserDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.sysmanage.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
