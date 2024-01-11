package com.hr.entity;

// 订单详情实体类（带订单信息）
public class EASYBUY_Ddan {
	private int EO_ID; // 订单ID
	private String EO_USER_ID; // 用户ID
	private String EP_NAME; // 商品名称
	private String EP_FILE_NAME; // 商品文件名
	private int EP_PRICE; // 商品价格
	private int EOD_QUANTITY; // 订单数量
	private int EP_STOCK; // 商品库存

	// 带参构造方法
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

	// 获取订单ID
	public int getEO_ID() {
		return EO_ID;
	}

	// 设置订单ID
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}

	// 获取用户ID
	public String getEO_USER_ID() {
		return EO_USER_ID;
	}

	// 设置用户ID
	public void setEO_USER_ID(String eOUSERID) {
		EO_USER_ID = eOUSERID;
	}

	// 获取商品名称
	public String getEP_NAME() {
		return EP_NAME;
	}

	// 设置商品名称
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}

	// 获取商品文件名
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}

	// 设置商品文件名
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}

	// 获取商品价格
	public int getEP_PRICE() {
		return EP_PRICE;
	}

	// 设置商品价格
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}

	// 获取订单数量
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}

	// 设置订单数量
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}

	// 获取商品库存
	public int getEP_STOCK() {
		return EP_STOCK;
	}

	// 设置商品库存
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}
}
