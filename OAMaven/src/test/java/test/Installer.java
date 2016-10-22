package test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wx.oa.domain.sysmanage.Privilege;
import com.wx.oa.domain.sysmanage.User;

/**
 * 权限数据的安装
 * 
 * @author Demons
 * 
 */
public class Installer extends SpringUtil {

	@Test
	public void install() {

		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// =====================================================
		// 保存超级管理员
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		session.save(user);

		// =====================================================
		// 保存权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5;

		// -----------------------------------------------------
		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/roleAction_showAllRoles", menu);
		menu2 = new Privilege("部门管理", "/departmentAction_showAllDepartments",
				menu);
		menu3 = new Privilege("用户管理", "/userAction_showAllUsers", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		session.save(new Privilege("岗位列表", "/roleAction_showAllRoles", menu1));
		session.save(new Privilege("岗位删除", "/roleAction_delete", menu1));
		session.save(new Privilege("岗位添加", "/roleAction_add", menu1));
		session.save(new Privilege("岗位修改", "/roleAction_update", menu1));
		session.save(new Privilege("设置权限", "/roleAction_setPrivilege", menu1));

		session.save(new Privilege("部门列表", "/departmentAction_showAllRoles",
				menu2));
		session.save(new Privilege("部门删除", "/departmentAction_delete", menu2));
		session.save(new Privilege("部门添加", "/departmentAction_add", menu2));
		session.save(new Privilege("部门修改", "/departmentAction_update", menu2));

		session.save(new Privilege("用户列表", "/userAction_showAllUsers", menu3));
		session.save(new Privilege("用户删除", "/userAction_delete", menu3));
		session.save(new Privilege("用户添加", "/userAction_add", menu3));
		session.save(new Privilege("用户修改", "/userAction_update", menu3));

		// -----------------------------------------------------
		menu = new Privilege("网上交流", null, null);
		menu1 = new Privilege("论坛管理", "/forumManage_list", menu);
		menu2 = new Privilege("论坛", "/form_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);

		// -----------------------------------------------------
		menu = new Privilege("审批流转", null, null);
		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
		menu2 = new Privilege("申请模板管理", "/template_list", menu);
		menu3 = new Privilege("起草申请", "/flow_templateList", menu);
		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);

		transaction.commit();
		session.close();
	}

}
