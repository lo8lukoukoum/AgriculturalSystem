package com.hr.entity;

// 商品分类实体类
public class EASYBUY_PRODUCT_CATEGORY {
	private int EPC_ID; // 商品分类ID
	private String EPC_NAME; // 商品分类名称
	private int EPC_PARENT_ID; // 商品分类父级ID

	// 带参构造方法
	public EASYBUY_PRODUCT_CATEGORY(int ePCID, String ePCNAME, int ePCPARENTID) {
		EPC_ID = ePCID;
		EPC_NAME = ePCNAME;
		EPC_PARENT_ID = ePCPARENTID;
	}

	// 获取商品分类ID
	public int getEPC_ID() {
		return EPC_ID;
	}

	// 设置商品分类ID
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}

	// 获取商品分类名称
	public String getEPC_NAME() {
		return EPC_NAME;
	}

	// 设置商品分类名称
	public void setEPC_NAME(String ePCNAME) {
		EPC_NAME = ePCNAME;
	}

	// 获取商品分类父级ID
	public int getEPC_PARENT_ID() {
		return EPC_PARENT_ID;
	}

	// 设置商品分类父级ID
	public void setEPC_PARENT_ID(int ePCPARENTID) {
		EPC_PARENT_ID = ePCPARENTID;
	}
}
