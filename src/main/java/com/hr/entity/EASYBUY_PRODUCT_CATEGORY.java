package com.hr.entity;

// ��Ʒ����ʵ����
public class EASYBUY_PRODUCT_CATEGORY {
	private int EPC_ID; // ��Ʒ����ID
	private String EPC_NAME; // ��Ʒ��������
	private int EPC_PARENT_ID; // ��Ʒ���ุ��ID

	// ���ι��췽��
	public EASYBUY_PRODUCT_CATEGORY(int ePCID, String ePCNAME, int ePCPARENTID) {
		EPC_ID = ePCID;
		EPC_NAME = ePCNAME;
		EPC_PARENT_ID = ePCPARENTID;
	}

	// ��ȡ��Ʒ����ID
	public int getEPC_ID() {
		return EPC_ID;
	}

	// ������Ʒ����ID
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}

	// ��ȡ��Ʒ��������
	public String getEPC_NAME() {
		return EPC_NAME;
	}

	// ������Ʒ��������
	public void setEPC_NAME(String ePCNAME) {
		EPC_NAME = ePCNAME;
	}

	// ��ȡ��Ʒ���ุ��ID
	public int getEPC_PARENT_ID() {
		return EPC_PARENT_ID;
	}

	// ������Ʒ���ุ��ID
	public void setEPC_PARENT_ID(int ePCPARENTID) {
		EPC_PARENT_ID = ePCPARENTID;
	}
}
