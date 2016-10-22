package com.wx.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.RoleDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.sysmanage.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

}
