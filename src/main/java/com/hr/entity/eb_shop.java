package com.hr.entity;

public class eb_shop {
	// 购物车id
	public int es_id;
	// 商品图片名称
	public String es_ep_file_name;
	// 商品名称
	public String es_ep_name;
	// 商品单价
	public int es_ep_price;
	// 购买数量
	public int es_eod_quantity;
	// 商品库存
	public int es_ep_stock;
	// 商品id
	public int es_ep_id;
	// 用户id
	public String es_EU_USER_ID;
	// 是否结账
	public int ea_valid;

	// 带参构造方法
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

	// 获取购物车id
	public int getEs_id() {
		return es_id;
	}

	// 设置购物车id
	public void setEs_id(int esId) {
		es_id = esId;
	}

	// 获取商品图片名称
	public String getEs_ep_file_name() {
		return es_ep_file_name;
	}

	// 设置商品图片名称
	public void setEs_ep_file_name(String esEpFileName) {
		es_ep_file_name = esEpFileName;
	}

	// 获取商品名称
	public String getEs_ep_name() {
		return es_ep_name;
	}

	// 设置商品名称
	public void setEs_ep_name(String esEpName) {
		es_ep_name = esEpName;
	}

	// 获取商品单价
	public int getEs_ep_price() {
		return es_ep_price;
	}

	// 设置商品单价
	public void setEs_ep_price(int esEpPrice) {
		es_ep_price = esEpPrice;
	}

	// 获取购买数量
	public int getEs_eod_quantity() {
		return es_eod_quantity;
	}

	// 设置购买数量
	public void setEs_eod_quantity(int esEodQuantity) {
		es_eod_quantity = esEodQuantity;
	}

	// 获取商品库存
	public int getEs_ep_stock() {
		return es_ep_stock;
	}

	// 设置商品库存
	public void setEs_ep_stock(int esEpStock) {
		es_ep_stock = esEpStock;
	}

	// 获取商品id
	public int getEs_ep_id() {
		return es_ep_id;
	}

	// 设置商品id
	public void setEs_ep_id(int esEpId) {
		es_ep_id = esEpId;
	}

	// 获取用户id
	public String getEs_EU_USER_ID() {
		return es_EU_USER_ID;
	}

	// 设置用户id
	public void setEs_EU_USER_ID(String esEUUSERID) {
		es_EU_USER_ID = esEUUSERID;
	}

	// 获取是否结账
	public int getEa_valid() {
		return ea_valid;
	}

	// 设置是否结账
	public void setEa_valid(int eaValid) {
		ea_valid = eaValid;
	}
}
