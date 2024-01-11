package com.hr.entity;

// 订单实体类
public class EASYBUY_ORDER {
	private int EO_ID; // 订单ID
	private String EO_USER_ID; // 用户ID
	private String EO_USER_NAME; // 用户名
	private String EO_USER_ADDRESS; // 用户地址
	private String EO_CREATE_TIME; // 订单创建时间
	private int EO_COST; // 订单总金额
	private int EO_STATUS; // 订单状态
	private int EO_TYPE; // 订单类型

	// 订单状态的字符串表示
	public String getOrderStatusStr() {
		if (this.EO_STATUS == 1) {
			return "待审核";
		} else if (this.EO_STATUS == 2) {
			return "审核通过";
		} else if (this.EO_STATUS == 3) {
			return "配货";
		} else if (this.EO_STATUS == 4) {
			return "发货";
		} else {
			return "确认收货";
		}
	}

	// 带参构造方法
	public EASYBUY_ORDER(int eOID, String eOUSERID, String eOUSERNAME,
						 String eOUSERADDRESS, String eOCREATETIME, int eOCOST,
						 int eOSTATUS, int eOTYPE) {
		EO_ID = eOID;
		EO_USER_ID = eOUSERID;
		EO_USER_NAME = eOUSERNAME;
		EO_USER_ADDRESS = eOUSERADDRESS;
		EO_CREATE_TIME = eOCREATETIME;
		EO_COST = eOCOST;
		EO_STATUS = eOSTATUS;
		EO_TYPE = eOTYPE;
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

	// 获取用户名
	public String getEO_USER_NAME() {
		return EO_USER_NAME;
	}

	// 设置用户名
	public void setEO_USER_NAME(String eOUSERNAME) {
		EO_USER_NAME = eOUSERNAME;
	}

	// 获取用户地址
	public String getEO_USER_ADDRESS() {
		return EO_USER_ADDRESS;
	}

	// 设置用户地址
	public void setEO_USER_ADDRESS(String eOUSERADDRESS) {
		EO_USER_ADDRESS = eOUSERADDRESS;
	}

	// 获取订单创建时间
	public String getEO_CREATE_TIME() {
		return EO_CREATE_TIME;
	}

	// 设置订单创建时间
	public void setEO_CREATE_TIME(String eOCREATETIME) {
		EO_CREATE_TIME = eOCREATETIME;
	}

	// 获取订单总金额
	public int getEO_COST() {
		return EO_COST;
	}

	// 设置订单总金额
	public void setEO_COST(int eOCOST) {
		EO_COST = eOCOST;
	}

	// 获取订单状态
	public int getEO_STATUS() {
		return EO_STATUS;
	}

	// 设置订单状态
	public void setEO_STATUS(int eOSTATUS) {
		EO_STATUS = eOSTATUS;
	}

	// 获取订单类型
	public int getEO_TYPE() {
		return EO_TYPE;
	}

	// 设置订单类型
	public void setEO_TYPE(int eOTYPE) {
		EO_TYPE = eOTYPE;
	}
}
