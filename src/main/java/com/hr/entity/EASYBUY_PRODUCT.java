package com.hr.entity;

// 商品实体类
public class EASYBUY_PRODUCT {
	private int EP_ID; // 商品ID
	private String EP_NAME; // 商品名称
	private String EP_DESCRIPTION; // 商品描述
	private int EP_PRICE; // 商品价格
	private int EP_STOCK; // 商品库存
	private int EPC_ID; // 商品分类ID
	private int EPC_CHILD_ID; // 商品子分类ID
	private String EP_FILE_NAME; // 商品图片文件名

	// 带参构造方法
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

	// 获取商品ID
	public int getEP_ID() {
		return EP_ID;
	}

	// 设置商品ID
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}

	// 获取商品名称
	public String getEP_NAME() {
		return EP_NAME;
	}

	// 设置商品名称
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}

	// 获取商品描述
	public String getEP_DESCRIPTION() {
		return EP_DESCRIPTION;
	}

	// 设置商品描述
	public void setEP_DESCRIPTION(String ePDESCRIPTION) {
		EP_DESCRIPTION = ePDESCRIPTION;
	}

	// 获取商品价格
	public int getEP_PRICE() {
		return EP_PRICE;
	}

	// 设置商品价格
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}

	// 获取商品库存
	public int getEP_STOCK() {
		return EP_STOCK;
	}

	// 设置商品库存
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}

	// 获取商品分类ID
	public int getEPC_ID() {
		return EPC_ID;
	}

	// 设置商品分类ID
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}

	// 获取商品子分类ID
	public int getEPC_CHILD_ID() {
		return EPC_CHILD_ID;
	}

	// 设置商品子分类ID
	public void setEPC_CHILD_ID(int ePCCHILDID) {
		EPC_CHILD_ID = ePCCHILDID;
	}

	// 获取商品图片文件名
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}

	// 设置商品图片文件名
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}
}
