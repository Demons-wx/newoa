package com.wx.oa.utils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wx.oa.domain.sysmanage.User;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user"); // 当前登录用户
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 正在请求的url

		// 如果没登录
		if (user == null) {
			if (privUrl.startsWith("/userAction_login")) {
				// 如果是去登录，就放行
				return invocation.invoke();
			} else {
				return "loginUI";
			}
		} else { // 如果已经登录，判断权限
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 有权限，放行
				return invocation.invoke();
			} else {
				// 没有权限，转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}
