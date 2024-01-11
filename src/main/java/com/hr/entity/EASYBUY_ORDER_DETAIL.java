package com.hr.entity;

// 订单详细实体类
public class EASYBUY_ORDER_DETAIL {
	private int EOD_ID; // 订单详细ID
	private int EO_ID; // 订单ID
	private int EP_ID; // 商品ID
	private int EOD_QUANTITY; // 订单商品数量
	private int EOD_COST; // 订单商品总价

	// 带参构造方法
	public EASYBUY_ORDER_DETAIL(int eODID, int eOID, int ePID, int eODQUANTITY,
								int eODCOST) {
		EOD_ID = eODID;
		EO_ID = eOID;
		EP_ID = ePID;
		EOD_QUANTITY = eODQUANTITY;
		EOD_COST = eODCOST;
	}

	// 获取订单详细ID
	public int getEOD_ID() {
		return EOD_ID;
	}

	// 设置订单详细ID
	public void setEOD_ID(int eODID) {
		EOD_ID = eODID;
	}

	// 获取订单ID
	public int getEO_ID() {
		return EO_ID;
	}

	// 设置订单ID
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}

	// 获取商品ID
	public int getEP_ID() {
		return EP_ID;
	}

	// 设置商品ID
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}

	// 获取订单商品数量
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}

	// 设置订单商品数量
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}

	// 获取订单商品总价
	public int getEOD_COST() {
		return EOD_COST;
	}

	// 设置订单商品总价
	public void setEOD_COST(int eODCOST) {
		EOD_COST = eODCOST;
	}
}
