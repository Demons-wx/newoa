package com.wx.oa.domain.sysmanage;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 岗位
 * 
 * @author Demons
 * 
 */
public class Role implements Serializable {

	private Long rid;
	private String name;
	private String description;
	// 好的习惯，要进行初始化，避免返回集合的时候返回空，而是要返回一个空集合
	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privileges = new HashSet<Privilege>();

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
