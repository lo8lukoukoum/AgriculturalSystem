package com.hr.entity;

// �û�ʵ����
public class EASYBUY_USER {
	private String EU_USER_ID; // �û�ID
	private String EU_USER_NAME; // �û���
	private String EU_PASSWORD; // ����
	private String EU_SEX; // �Ա�
	private String EU_BIRTHDAY; // ����
	private String EU_IDENTITY_CODE; // ���֤��
	private String EU_EMAIL; // �����ʼ�
	private String EU_MOBILE; // �ֻ�����
	private String EU_ADDRESS; // ��ַ
	private int EU_STATUS; // �û�״̬

	// ���ι��췽��
	public EASYBUY_USER(String eUUSERID, String eUUSERNAME, String eUPASSWORD,
						String eUSEX, String eUBIRTHDAY, String eUIDENTITYCODE,
						String eUEMAIL, String eUMOBILE, String eUADDRESS, int eUSTATUS) {
		EU_USER_ID = eUUSERID;
		EU_USER_NAME = eUUSERNAME;
		EU_PASSWORD = eUPASSWORD;
		EU_SEX = eUSEX;
		EU_BIRTHDAY = eUBIRTHDAY;
		EU_IDENTITY_CODE = eUIDENTITYCODE;
		EU_EMAIL = eUEMAIL;
		EU_MOBILE = eUMOBILE;
		EU_ADDRESS = eUADDRESS;
		EU_STATUS = eUSTATUS;
	}

	// ��ȡ�û�ID
	public String getEU_USER_ID() {
		return EU_USER_ID;
	}

	// �����û�ID
	public void setEU_USER_ID(String eUUSERID) {
		EU_USER_ID = eUUSERID;
	}

	// ��ȡ�û���
	public String getEU_USER_NAME() {
		return EU_USER_NAME;
	}

	// �����û���
	public void setEU_USER_NAME(String eUUSERNAME) {
		EU_USER_NAME = eUUSERNAME;
	}

	// ��ȡ����
	public String getEU_PASSWORD() {
		return EU_PASSWORD;
	}

	// ��������
	public void setEU_PASSWORD(String eUPASSWORD) {
		EU_PASSWORD = eUPASSWORD;
	}

	// ��ȡ�Ա�
	public String getEU_SEX() {
		return EU_SEX;
	}

	// �����Ա�
	public void setEU_SEX(String eUSEX) {
		EU_SEX = eUSEX;
	}

	// ��ȡ����
	public String getEU_BIRTHDAY() {
		return EU_BIRTHDAY;
	}

	// ��������
	public void setEU_BIRTHDAY(String eUBIRTHDAY) {
		EU_BIRTHDAY = eUBIRTHDAY;
	}

	// ��ȡ���֤��
	public String getEU_IDENTITY_CODE() {
		return EU_IDENTITY_CODE;
	}

	// �������֤��
	public void setEU_IDENTITY_CODE(String eUIDENTITYCODE) {
		EU_IDENTITY_CODE = eUIDENTITYCODE;
	}

	// ��ȡ�����ʼ�
	public String getEU_EMAIL() {
		return EU_EMAIL;
	}

	// ���õ����ʼ�
	public void setEU_EMAIL(String eUEMAIL) {
		EU_EMAIL = eUEMAIL;
	}

	// ��ȡ�ֻ�����
	public String getEU_MOBILE() {
		return EU_MOBILE;
	}

	// �����ֻ�����
	public void setEU_MOBILE(String eUMOBILE) {
		EU_MOBILE = eUMOBILE;
	}

	// ��ȡ��ַ
	public String getEU_ADDRESS() {
		return EU_ADDRESS;
	}

	// ���õ�ַ
	public void setEU_ADDRESS(String eUADDRESS) {
		EU_ADDRESS = eUADDRESS;
	}

	// ��ȡ�û�״̬
	public int getEU_STATUS() {
		return EU_STATUS;
	}

	// �����û�״̬
	public void setEU_STATUS(int eUSTATUS) {
		EU_STATUS = eUSTATUS;
	}
}
