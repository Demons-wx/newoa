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
import com.wx.oa.domain.sysmanage.Department;
import com.wx.oa.service.DepartmentService;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	// 显示所有部门
	public String showAllDepartments() {
		
		String hql = "from Department";
		List<Object> parameters = new ArrayList<Object>();
		PageBean pageBean = departmentService.getPageBean(pageNum, pageSize2, hql, parameters);

		ActionContext.getContext().getValueStack().push(pageBean);
		
		return listAction;
	}

	// 跳转到增加页面
	public String addUI() {
		Collection<Department> departments = departmentService
				.getAllDepartments();
		ActionContext.getContext().put("departments", departments);
		return addUI;
	}

	// 增加部门
	public String add() {
		Department department = new Department();
		BeanUtils.copyProperties(getModel(), department);
		departmentService.saveDepartment(department);
		return action2action;
	}

	// 跳转到修改页面
	public String updateUI() {
		Collection<Department> departments = departmentService
				.getAllDepartments();
		Department department = departmentService.getDepartmentById(getModel()
				.getDid());
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}

	// 修改
	public String update() {
		Department department = departmentService.getDepartmentById(getModel()
				.getDid());
		BeanUtils.copyProperties(getModel(), department);
		departmentService.updateDepartment(department);
		return action2action;
	}

	// 删除
	public String delete() {
		departmentService.deleteDepartment(getModel().getDid());
		return action2action;
	}

	// 添加一行没用的注释
}
