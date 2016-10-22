package com.wx.oa.domain.forummanage;

import java.util.Date;

import com.wx.oa.domain.sysmanage.User;


/**
 * 文章
 * @author Demons
 *
 */
public class Article {

	private Long id;
	private String title; // 标题
	private String content; // 内容
	private User author; // 作者
	private Date postTime; // 发表时间
	private String ipAddr; // 发表文章时用到的IP地址
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public User getAuthor() {
		return author;
	}
	public Date getPostTime() {
		return postTime;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	
}
