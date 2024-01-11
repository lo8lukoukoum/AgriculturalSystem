package com.hr.entity;

// ����ʵ����
public class EASYBUY_ORDER {
	private int EO_ID; // ����ID
	private String EO_USER_ID; // �û�ID
	private String EO_USER_NAME; // �û���
	private String EO_USER_ADDRESS; // �û���ַ
	private String EO_CREATE_TIME; // ��������ʱ��
	private int EO_COST; // �����ܽ��
	private int EO_STATUS; // ����״̬
	private int EO_TYPE; // ��������

	// ����״̬���ַ�����ʾ
	public String getOrderStatusStr() {
		if (this.EO_STATUS == 1) {
			return "�����";
		} else if (this.EO_STATUS == 2) {
			return "���ͨ��";
		} else if (this.EO_STATUS == 3) {
			return "���";
		} else if (this.EO_STATUS == 4) {
			return "����";
		} else {
			return "ȷ���ջ�";
		}
	}

	// ���ι��췽��
	public EASYBUY_ORDER(int eOID, String eOUSERID, String eOUSERNAME,
						 String eOUSERADDRESS, String eOCREATETIME, int eOCOST,
						 int eOSTATUS, int eOTYPE) {
		EO_ID = eOID;
		EO_USER_ID = eOUSERID;
		EO_USER_NAME = eOUSERNAME;
		EO_USER_ADDRESS = eOUSERADDRESS;
		EO_CREATE_TIME = eOCREATETIME;
		EO_COST = eOCOST;
		EO_STATUS = eOSTATUS;
		EO_TYPE = eOTYPE;
	}

	// ��ȡ����ID
	public int getEO_ID() {
		return EO_ID;
	}

	// ���ö���ID
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}

	// ��ȡ�û�ID
	public String getEO_USER_ID() {
		return EO_USER_ID;
	}

	// �����û�ID
	public void setEO_USER_ID(String eOUSERID) {
		EO_USER_ID = eOUSERID;
	}

	// ��ȡ�û���
	public String getEO_USER_NAME() {
		return EO_USER_NAME;
	}

	// �����û���
	public void setEO_USER_NAME(String eOUSERNAME) {
		EO_USER_NAME = eOUSERNAME;
	}

	// ��ȡ�û���ַ
	public String getEO_USER_ADDRESS() {
		return EO_USER_ADDRESS;
	}

	// �����û���ַ
	public void setEO_USER_ADDRESS(String eOUSERADDRESS) {
		EO_USER_ADDRESS = eOUSERADDRESS;
	}

	// ��ȡ��������ʱ��
	public String getEO_CREATE_TIME() {
		return EO_CREATE_TIME;
	}

	// ���ö�������ʱ��
	public void setEO_CREATE_TIME(String eOCREATETIME) {
		EO_CREATE_TIME = eOCREATETIME;
	}

	// ��ȡ�����ܽ��
	public int getEO_COST() {
		return EO_COST;
	}

	// ���ö����ܽ��
	public void setEO_COST(int eOCOST) {
		EO_COST = eOCOST;
	}

	// ��ȡ����״̬
	public int getEO_STATUS() {
		return EO_STATUS;
	}

	// ���ö���״̬
	public void setEO_STATUS(int eOSTATUS) {
		EO_STATUS = eOSTATUS;
	}

	// ��ȡ��������
	public int getEO_TYPE() {
		return EO_TYPE;
	}

	// ���ö�������
	public void setEO_TYPE(int eOTYPE) {
		EO_TYPE = eOTYPE;
	}
}
