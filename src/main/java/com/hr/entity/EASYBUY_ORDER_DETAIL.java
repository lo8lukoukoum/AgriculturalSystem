package com.hr.entity;

// ������ϸʵ����
public class EASYBUY_ORDER_DETAIL {
	private int EOD_ID; // ������ϸID
	private int EO_ID; // ����ID
	private int EP_ID; // ��ƷID
	private int EOD_QUANTITY; // ������Ʒ����
	private int EOD_COST; // ������Ʒ�ܼ�

	// ���ι��췽��
	public EASYBUY_ORDER_DETAIL(int eODID, int eOID, int ePID, int eODQUANTITY,
								int eODCOST) {
		EOD_ID = eODID;
		EO_ID = eOID;
		EP_ID = ePID;
		EOD_QUANTITY = eODQUANTITY;
		EOD_COST = eODCOST;
	}

	// ��ȡ������ϸID
	public int getEOD_ID() {
		return EOD_ID;
	}

	// ���ö�����ϸID
	public void setEOD_ID(int eODID) {
		EOD_ID = eODID;
	}

	// ��ȡ����ID
	public int getEO_ID() {
		return EO_ID;
	}

	// ���ö���ID
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}

	// ��ȡ��ƷID
	public int getEP_ID() {
		return EP_ID;
	}

	// ������ƷID
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}

	// ��ȡ������Ʒ����
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}

	// ���ö�����Ʒ����
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}

	// ��ȡ������Ʒ�ܼ�
	public int getEOD_COST() {
		return EOD_COST;
	}

	// ���ö�����Ʒ�ܼ�
	public void setEOD_COST(int eODCOST) {
		EOD_COST = eODCOST;
	}
}
