package com.hr.entity;

// ��������ʵ���ࣨ��������Ϣ��
public class EASYBUY_Ddan {
	private int EO_ID; // ����ID
	private String EO_USER_ID; // �û�ID
	private String EP_NAME; // ��Ʒ����
	private String EP_FILE_NAME; // ��Ʒ�ļ���
	private int EP_PRICE; // ��Ʒ�۸�
	private int EOD_QUANTITY; // ��������
	private int EP_STOCK; // ��Ʒ���

	// ���ι��췽��
	public EASYBUY_Ddan(int eOID, String eOUSERID, String ePNAME,
						String ePFILENAME, int ePPRICE, int eODQUANTITY, int ePSTOCK) {
		EO_ID = eOID;
		EO_USER_ID = eOUSERID;
		EP_NAME = ePNAME;
		EP_FILE_NAME = ePFILENAME;
		EP_PRICE = ePPRICE;
		EOD_QUANTITY = eODQUANTITY;
		EP_STOCK = ePSTOCK;
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

	// ��ȡ��Ʒ����
	public String getEP_NAME() {
		return EP_NAME;
	}

	// ������Ʒ����
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}

	// ��ȡ��Ʒ�ļ���
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}

	// ������Ʒ�ļ���
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}

	// ��ȡ��Ʒ�۸�
	public int getEP_PRICE() {
		return EP_PRICE;
	}

	// ������Ʒ�۸�
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}

	// ��ȡ��������
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}

	// ���ö�������
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}

	// ��ȡ��Ʒ���
	public int getEP_STOCK() {
		return EP_STOCK;
	}

	// ������Ʒ���
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}
}
