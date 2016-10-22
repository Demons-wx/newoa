package com.wx.oa.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Privilege;
import com.wx.oa.domain.sysmanage.Role;
import com.wx.oa.service.PrivilegeService;
import com.wx.oa.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	@Resource(name = "roleService")
	private RoleService roleService;
	@Resource(name = "privilegeService")
	private PrivilegeService privilegeService;

	private Long[] privilegeIds;

	// 显示所有岗位
	public String showAllRoles() {
		
		String hql = "from Role";
		List<Object> parameters = new ArrayList<Object>();
		PageBean pageBean = roleService.getPageBean(pageNum, pageSize2, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return listAction;
	}

	// 跳转到增加页面
	public String addUI() {
		return addUI;
	}

	// 增加岗位
	public String add() {
		Role role = new Role();
		BeanUtils.copyProperties(getModel(), role);
		roleService.saveRole(role);
		return action2action;
	}

	// 跳转到修改页面
	public String updateUI() {
		Role role = roleService.getRoleById(getModel().getRid());
		ActionContext.getContext().getValueStack().push(role);
		return updateUI;
	}

	// 修改
	public String update() {
		Role role = roleService.getRoleById(getModel().getRid());
		BeanUtils.copyProperties(getModel(), role);
		roleService.updateRole(role);
		return action2action;
	}

	// 删除
	public String delete() {
		roleService.deleteRole(getModel().getRid());
		return action2action;
	}

	// 设置权限页
	public String setPrivilegeUI() {
		// 准备回显的数据
		Role role = roleService.getRoleById(getModel().getRid());
		ActionContext.getContext().getValueStack().push(role);

		if (role.getPrivileges() != null) {
			privilegeIds = new Long[role.getPrivileges().size()];
			int index = 0;
			for (Privilege privilege : role.getPrivileges()) {
				privilegeIds[index++] = privilege.getId();
			}
		}
		return setPrivilegeUI;
	}

	// 设置权限
	public String setPrivilege() {
		Role role = roleService.getRoleById(getModel().getRid());
		Set<Privilege> privilegeList = (Set<Privilege>) privilegeService
				.getPrivilegeByIds(privilegeIds);
		if (privilegeList != null) {
			role.setPrivileges(new HashSet<Privilege>(privilegeList));
		} else {
			role.setPrivileges(null);
		}
		roleService.updateRole(role);
		return action2action;
	}

	// --------------------------------
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
