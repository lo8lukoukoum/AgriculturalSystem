package com.hr.entity;

// ��������ʵ����
public class EASYBUY_DD {
	private String EP_NAME; // ��Ʒ����
	private String EP_FILE_NAME; // ��Ʒ�ļ���
	private int EP_PRICE; // ��Ʒ�۸�
	private int EOD_QUANTITY; // ��������
	private int EP_STOCK; // ��Ʒ���

	// ���ι��췽��
	public EASYBUY_DD(String ePNAME, String ePFILENAME, int ePPRICE,
					  int eODQUANTITY, int ePSTOCK) {
		EP_NAME = ePNAME;
		EP_FILE_NAME = ePFILENAME;
		EP_PRICE = ePPRICE;
		EOD_QUANTITY = eODQUANTITY;
		EP_STOCK = ePSTOCK;
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
