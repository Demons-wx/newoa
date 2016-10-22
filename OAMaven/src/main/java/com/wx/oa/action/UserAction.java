package com.wx.oa.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wx.oa.action.base.BaseAction;
import com.wx.oa.domain.PageBean;
import com.wx.oa.domain.sysmanage.Department;
import com.wx.oa.domain.sysmanage.Privilege;
import com.wx.oa.domain.sysmanage.Role;
import com.wx.oa.domain.sysmanage.User;
import com.wx.oa.service.DepartmentService;
import com.wx.oa.service.PrivilegeService;
import com.wx.oa.service.RoleService;
import com.wx.oa.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "departmentService")
	private DepartmentService departmentService;
	@Resource(name = "roleService")
	private RoleService roleService;
	@Resource(name = "privilegeService")
	private PrivilegeService privilegeService;

	private Long did;
	private Long[] rids;
	
	private String oldPass;
	private String newPass_1;
	private String newPass_2;

	// 显示所有用户
	public String showAllUsers() {
		
		String hql = "from User";
		List<Object> parameters = new ArrayList<Object>();
		PageBean pageBean = userService.getPageBean(pageNum, pageSize2, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return listAction;
	}

	// 跳转到增加页面
	public String addUI() {
		Collection<Department> departments = departmentService
				.getAllDepartments();
		Collection<Role> roles = roleService.getAllRoles();
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().put("roles", roles);
		return addUI;
	}

	// 增加用户
	public String add() {
		User user = new User();
		BeanUtils.copyProperties(getModel(), user);
		userService.saveUser(did, rids, user); // 保存用户的同时保存与之关联的部门和岗位
		return action2action;
	}

	// 跳转到修改页面
	public String updateUI() {
		User user = userService.getUserById(getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		did = user.getDepartment().getDid();
		Set<Role> roles = user.getRoles();
		rids = new Long[roles.size()];
		int index = 0;
		for (Role role : roles) {
			rids[index] = role.getRid();
			index++;
		}
		Collection<Department> departments = departmentService
				.getAllDepartments();
		Collection<Role> roles2 = roleService.getAllRoles();
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().put("roles", roles2);
		return updateUI;
	}

	// 修改(修改的时候不会改变密码)
	public String update() {
		User user = userService.getUserById(getModel().getUid());
		String oldPass = user.getPassword(); // 旧密码
		BeanUtils.copyProperties(getModel(), user);
		user.setPassword(oldPass);
		userService.updateUser(did, rids, user);
		return action2action;
	}

	// 删除
	public String delete() {
		userService.deleteUser(getModel().getUid());
		return action2action;
	}

	// 登录
	public String login() {
		User user = userService.login(getModel().getUsername(), getModel()
				.getPassword());
		if (user == null) {
			addActionMessage("用户名或密码不正确");
			return "input";
		} else {
			ActionContext.getContext().getSession().put("user", user);
			return mainUI;
		}
	}

	// 注销
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		return "input"; // 退出到登录页面
	}

	// 无权限访问的时候返回首页
	public String backToMain() {
		return mainUI;
	}
	
	// 跳转到修改密码界面
	public String updatePasswordUI(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		did = user.getDepartment().getDid();
		Set<Role> roles = user.getRoles();
		rids = new Long[roles.size()];
		int index = 0;
		for (Role role : roles) {
			rids[index] = role.getRid();
			index++;
		}
		ActionContext.getContext().getValueStack().push(user);
		return "updatePasswordUI";
	}

	// 修改密码
	public String updatePassword(){
		User currentUser = (User) ActionContext.getContext().getSession().get("user");
		if(!oldPass.equals(currentUser.getPassword())){
			addActionMessage("原始密码错误！");
			return "updatePasswordUI";
		}
		if(!newPass_1.equals(newPass_2)){
			addActionMessage("两次输入的密码不一致！");
			return "updatePasswordUI";
		}
		User user = userService.getUserById(model.getUid());
		user.setPassword(newPass_1);
		userService.updateUser(did, rids, user);
		return SUCCESS;
	}
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getRids() {
		return rids;
	}

	public void setRids(Long[] rids) {
		this.rids = rids;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass_1() {
		return newPass_1;
	}

	public String getNewPass_2() {
		return newPass_2;
	}

	
	public void setNewPass_1(String newPass_1) {
		this.newPass_1 = newPass_1;
	}

	public void setNewPass_2(String newPass_2) {
		this.newPass_2 = newPass_2;
	}
	
}
