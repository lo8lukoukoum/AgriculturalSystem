package com.hr.entity;

// ��Ʒʵ����
public class EASYBUY_PRODUCT {
	private int EP_ID; // ��ƷID
	private String EP_NAME; // ��Ʒ����
	private String EP_DESCRIPTION; // ��Ʒ����
	private int EP_PRICE; // ��Ʒ�۸�
	private int EP_STOCK; // ��Ʒ���
	private int EPC_ID; // ��Ʒ����ID
	private int EPC_CHILD_ID; // ��Ʒ�ӷ���ID
	private String EP_FILE_NAME; // ��ƷͼƬ�ļ���

	// ���ι��췽��
	public EASYBUY_PRODUCT(int ePID, String ePNAME, String ePDESCRIPTION,
						   int ePPRICE, int ePSTOCK, int ePCID, int ePCCHILDID,
						   String ePFILENAME) {
		EP_ID = ePID;
		EP_NAME = ePNAME;
		EP_DESCRIPTION = ePDESCRIPTION;
		EP_PRICE = ePPRICE;
		EP_STOCK = ePSTOCK;
		EPC_ID = ePCID;
		EPC_CHILD_ID = ePCCHILDID;
		EP_FILE_NAME = ePFILENAME;
	}

	// ��ȡ��ƷID
	public int getEP_ID() {
		return EP_ID;
	}

	// ������ƷID
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}

	// ��ȡ��Ʒ����
	public String getEP_NAME() {
		return EP_NAME;
	}

	// ������Ʒ����
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}

	// ��ȡ��Ʒ����
	public String getEP_DESCRIPTION() {
		return EP_DESCRIPTION;
	}

	// ������Ʒ����
	public void setEP_DESCRIPTION(String ePDESCRIPTION) {
		EP_DESCRIPTION = ePDESCRIPTION;
	}

	// ��ȡ��Ʒ�۸�
	public int getEP_PRICE() {
		return EP_PRICE;
	}

	// ������Ʒ�۸�
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}

	// ��ȡ��Ʒ���
	public int getEP_STOCK() {
		return EP_STOCK;
	}

	// ������Ʒ���
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}

	// ��ȡ��Ʒ����ID
	public int getEPC_ID() {
		return EPC_ID;
	}

	// ������Ʒ����ID
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}

	// ��ȡ��Ʒ�ӷ���ID
	public int getEPC_CHILD_ID() {
		return EPC_CHILD_ID;
	}

	// ������Ʒ�ӷ���ID
	public void setEPC_CHILD_ID(int ePCCHILDID) {
		EPC_CHILD_ID = ePCCHILDID;
	}

	// ��ȡ��ƷͼƬ�ļ���
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}

	// ������ƷͼƬ�ļ���
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}
}
