package com.hr.entity;

public class eb_shop {
	// ���ﳵid
	public int es_id;
	// ��ƷͼƬ����
	public String es_ep_file_name;
	// ��Ʒ����
	public String es_ep_name;
	// ��Ʒ����
	public int es_ep_price;
	// ��������
	public int es_eod_quantity;
	// ��Ʒ���
	public int es_ep_stock;
	// ��Ʒid
	public int es_ep_id;
	// �û�id
	public String es_EU_USER_ID;
	// �Ƿ����
	public int ea_valid;

	// ���ι��췽��
	public eb_shop(int esId, String esEpFileName, String esEpName,
				   int esEpPrice, int esEodQuantity, int esEpStock, int esEpId,
				   String esEUUSERID, int eaValid) {
		es_id = esId;
		es_ep_file_name = esEpFileName;
		es_ep_name = esEpName;
		es_ep_price = esEpPrice;
		es_eod_quantity = esEodQuantity;
		es_ep_stock = esEpStock;
		es_ep_id = esEpId;
		es_EU_USER_ID = esEUUSERID;
		ea_valid = eaValid;
	}

	// ��ȡ���ﳵid
	public int getEs_id() {
		return es_id;
	}

	// ���ù��ﳵid
	public void setEs_id(int esId) {
		es_id = esId;
	}

	// ��ȡ��ƷͼƬ����
	public String getEs_ep_file_name() {
		return es_ep_file_name;
	}

	// ������ƷͼƬ����
	public void setEs_ep_file_name(String esEpFileName) {
		es_ep_file_name = esEpFileName;
	}

	// ��ȡ��Ʒ����
	public String getEs_ep_name() {
		return es_ep_name;
	}

	// ������Ʒ����
	public void setEs_ep_name(String esEpName) {
		es_ep_name = esEpName;
	}

	// ��ȡ��Ʒ����
	public int getEs_ep_price() {
		return es_ep_price;
	}

	// ������Ʒ����
	public void setEs_ep_price(int esEpPrice) {
		es_ep_price = esEpPrice;
	}

	// ��ȡ��������
	public int getEs_eod_quantity() {
		return es_eod_quantity;
	}

	// ���ù�������
	public void setEs_eod_quantity(int esEodQuantity) {
		es_eod_quantity = esEodQuantity;
	}

	// ��ȡ��Ʒ���
	public int getEs_ep_stock() {
		return es_ep_stock;
	}

	// ������Ʒ���
	public void setEs_ep_stock(int esEpStock) {
		es_ep_stock = esEpStock;
	}

	// ��ȡ��Ʒid
	public int getEs_ep_id() {
		return es_ep_id;
	}

	// ������Ʒid
	public void setEs_ep_id(int esEpId) {
		es_ep_id = esEpId;
	}

	// ��ȡ�û�id
	public String getEs_EU_USER_ID() {
		return es_EU_USER_ID;
	}

	// �����û�id
	public void setEs_EU_USER_ID(String esEUUSERID) {
		es_EU_USER_ID = esEUUSERID;
	}

	// ��ȡ�Ƿ����
	public int getEa_valid() {
		return ea_valid;
	}

	// �����Ƿ����
	public void setEa_valid(int eaValid) {
		ea_valid = eaValid;
	}
}
