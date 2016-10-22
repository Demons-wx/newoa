package com.wx.oa.domain.forummanage;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 主题
 * @author Demons
 *
 */
public class Topic extends Article{

	// 普通帖
	public static final int TYPE_NORMAL = 0;
	// 精华帖
	public static final int TYPE_BEST = 1;
	// 置顶帖
	public static final int TYPE_TOP = 2;
	
	private Forum forum; // 所属板块
	private Set<Reply> replies = new HashSet<Reply>();
	private int type; // 类型
	private int replyCount; // 回复数量
	private Reply lastReply; // 最后回复
	private Date lastUpdateTime; // 最后更新时间
	
	public Forum getForum() {
		return forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public int getType() {
		return type;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}
