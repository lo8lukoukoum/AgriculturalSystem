package com.hr.entity;

// ����ʵ����
public class EASYBUY_NEWS {
	private int EN_ID; // ����ID
	private String EN_TITLE; // ���ű���
	private String EN_CONTENT; // ��������
	private String EN_CREATE_TIME; // ���Ŵ���ʱ��

	// ���ι��췽��
	public EASYBUY_NEWS(int eNID, String eNTITLE, String eNCONTENT,
						String eNCREATETIME) {
		EN_ID = eNID;
		EN_TITLE = eNTITLE;
		EN_CONTENT = eNCONTENT;
		EN_CREATE_TIME = eNCREATETIME;
	}

	// ��ȡ����ID
	public int getEN_ID() {
		return EN_ID;
	}

	// ��������ID
	public void setEN_ID(int eNID) {
		EN_ID = eNID;
	}

	// ��ȡ���ű���
	public String getEN_TITLE() {
		return EN_TITLE;
	}

	// �������ű���
	public void setEN_TITLE(String eNTITLE) {
		EN_TITLE = eNTITLE;
	}

	// ��ȡ��������
	public String getEN_CONTENT() {
		return EN_CONTENT;
	}

	// ������������
	public void setEN_CONTENT(String eNCONTENT) {
		EN_CONTENT = eNCONTENT;
	}

	// ��ȡ���Ŵ���ʱ��
	public String getEN_CREATE_TIME() {
		return EN_CREATE_TIME;
	}

	// �������Ŵ���ʱ��
	public void setEN_CREATE_TIME(String eNCREATETIME) {
		EN_CREATE_TIME = eNCREATETIME;
	}
}
