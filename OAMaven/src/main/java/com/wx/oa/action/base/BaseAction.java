package com.wx.oa.action.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wx.oa.domain.sysmanage.User;

public class BaseAction<E> extends ActionSupport implements ModelDriven<E> {

	private Class clazz;
	protected E model;
	
	protected int pageNum = 1;
	protected int pageSize = 8;
	protected int pageSize2 = 3;

	public BaseAction() {
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];

		try {
			model = (E) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public E getModel() {
		return model;
	}

	// 跳转到列表页面
	public static final String LISTACTION = "listAction";
	public static String listAction = LISTACTION;

	// 跳转到修改页面
	public static final String UPDATE_UI = "updateUI";
	public static String updateUI = UPDATE_UI;

	// 跳转到增加页面
	public static final String ADD_UI = "addUI";
	public static String addUI = ADD_UI;

	// 跳转到权限页面
	public static final String SETPRIVILEGE_UI = "setPrivilegeUI";
	public static String setPrivilegeUI = SETPRIVILEGE_UI;

	// 跳转到增加页面
	public static final String MAIN_UI = "mainUI";
	public static String mainUI = MAIN_UI;

	// 跳转到另一个action
	public static final String ACTION2ACTION = "action2action";
	public static String action2action = ACTION2ACTION;

	// 获取当前登录用户
	protected User getCurrentUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
