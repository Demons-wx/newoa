package com.wx.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.wx.oa.domain.PageBean;

public interface BaseDao<E> {

	// 获取所有实体
	public Collection<E> getAllEntry();

	// 根据id获取实体
	public E getEntryById(Serializable id);

	// 保存
	public void saveEntry(E e);

	// 删除
	public void deleteEntry(Serializable id);

	// 修改
	public void updateEntry(E e);

	// 根据id获取一组实体
	public Collection<E> getEntryByIds(Serializable[] ids);

	// ids 是一个字符串的情况
	public Set<E> getEntryByIds(String ids);

	// 通过条件获取实体
	public E getEntryByCondition(final String entityName,
			final String... objects);
	
	// 公共查询分页的方法
	public 	PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);
}
