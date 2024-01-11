package com.hr.entity;

// 新闻实体类
public class EASYBUY_NEWS {
	private int EN_ID; // 新闻ID
	private String EN_TITLE; // 新闻标题
	private String EN_CONTENT; // 新闻内容
	private String EN_CREATE_TIME; // 新闻创建时间

	// 带参构造方法
	public EASYBUY_NEWS(int eNID, String eNTITLE, String eNCONTENT,
						String eNCREATETIME) {
		EN_ID = eNID;
		EN_TITLE = eNTITLE;
		EN_CONTENT = eNCONTENT;
		EN_CREATE_TIME = eNCREATETIME;
	}

	// 获取新闻ID
	public int getEN_ID() {
		return EN_ID;
	}

	// 设置新闻ID
	public void setEN_ID(int eNID) {
		EN_ID = eNID;
	}

	// 获取新闻标题
	public String getEN_TITLE() {
		return EN_TITLE;
	}

	// 设置新闻标题
	public void setEN_TITLE(String eNTITLE) {
		EN_TITLE = eNTITLE;
	}

	// 获取新闻内容
	public String getEN_CONTENT() {
		return EN_CONTENT;
	}

	// 设置新闻内容
	public void setEN_CONTENT(String eNCONTENT) {
		EN_CONTENT = eNCONTENT;
	}

	// 获取新闻创建时间
	public String getEN_CREATE_TIME() {
		return EN_CREATE_TIME;
	}

	// 设置新闻创建时间
	public void setEN_CREATE_TIME(String eNCREATETIME) {
		EN_CREATE_TIME = eNCREATETIME;
	}
}
