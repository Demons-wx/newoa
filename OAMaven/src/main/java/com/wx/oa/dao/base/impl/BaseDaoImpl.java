package com.wx.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wx.oa.dao.base.BaseDao;
import com.wx.oa.domain.PageBean;

public class BaseDaoImpl<E> implements BaseDao<E> {

	public Class clazz;
	ClassMetadata metadata;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}

	@PostConstruct
	public void init() {
		metadata = hibernateTemplate.getSessionFactory()
				.getClassMetadata(clazz);
	}

	@Resource(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	public Collection<E> getAllEntry() {
		return hibernateTemplate.find("from " + clazz.getName());
	}

	public E getEntryById(Serializable id) {
		return (E) hibernateTemplate.find(
				"from " + clazz.getName() + " where "
						+ metadata.getIdentifierPropertyName() + "=?", id).get(
				0);
	}

	public void saveEntry(E e) {
		hibernateTemplate.save(e);
	}

	public void deleteEntry(Serializable id) {
		E e = getEntryById(id);
		hibernateTemplate.delete(e);
	}

	public void updateEntry(E e) {
		hibernateTemplate.update(e);
	}

	public Collection<E> getEntryByIds(Serializable[] ids) {
		if (ids == null)
			return null;
		// 拼成一条语句，如：from role where rid in (1,2,3);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from " + clazz.getName());
		stringBuffer.append(" where " + metadata.getIdentifierPropertyName());
		stringBuffer.append(" in (");
		for (int i = 0; i < ids.length; i++) {
			if (i == ids.length - 1) {
				stringBuffer.append(ids[i]);
			} else {
				stringBuffer.append(ids[i] + ",");
			}
		}
		stringBuffer.append(")");
		List<E> list = hibernateTemplate.find(stringBuffer.toString());
		return new HashSet<E>(list);
	}

	public Set<E> getEntryByIds(String ids) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from " + clazz.getName());
		stringBuffer.append(" where " + metadata.getIdentifierPropertyName());
		stringBuffer.append(" in (");
		stringBuffer.append(ids);
		stringBuffer.append(")");
		List<E> list = hibernateTemplate.find(stringBuffer.toString());
		return new HashSet<E>(list);
	}

	public E getEntryByCondition(final String hql, final String... objects) {
		return hibernateTemplate.execute(new HibernateCallback<E>() {
			public E doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				int index = 0;
				for (String s : objects) {
					query.setParameter(index, s);
					index++;
				}
				return (E) query.uniqueResult();

			}
		});
	}

	public PageBean getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		// 查询本页的数据列表
		Query listQuery = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		if(parameters != null){
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list();
		// 查询总记录数
		Query countQuery = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("SELECT COUNT(*) "+hql);
		if(parameters != null){
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); 
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}
}
