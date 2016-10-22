package com.wx.oa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.oa.dao.ForumDao;
import com.wx.oa.dao.base.impl.BaseDaoImpl;
import com.wx.oa.domain.forummanage.Forum;

@Repository("forumDao")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao {

	public List<Forum> getAllForums() {
		return hibernateTemplate.find("from Forum f order by f.position");
	}

	public void saveForum(Forum forum) {
		// 保存
		super.saveEntry(forum);
		// 设置position的值
		forum.setPosition(forum.getId().intValue());
		// 持久化状态的对象，flush()的时候会自动提交
	}

	public void moveUp(Serializable id) {
		Forum forum = getEntryById(id); // 当前要移动的forum
		Forum other = null;
		Boolean flag = hibernateTemplate.find(
				"from Forum f where f.position<? order by f.position desc",
				forum.getPosition()).isEmpty();
		if (!flag)
			other = (Forum) hibernateTemplate.find(
					"from Forum f where f.position<? order by f.position desc",
					forum.getPosition()).get(0);
		// 最上面的不能上移
		if (other == null)
			return;
		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		hibernateTemplate.update(forum);
		hibernateTemplate.update(other);

	}

	public void moveDown(Serializable id) {
		Forum forum = getEntryById(id); // 当前要移动的forum
		Forum other = null;
		Boolean flag = hibernateTemplate.find(
				"from Forum f where f.position>? order by f.position",
				forum.getPosition()).isEmpty();
		if (!flag)
			other = (Forum) hibernateTemplate.find(
					"from Forum f where f.position>? order by f.position",
					forum.getPosition()).get(0);
		// 最下面的不能下移
		if (other == null)
			return;
		// 交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		hibernateTemplate.update(forum);
		hibernateTemplate.update(other);
	}

}
