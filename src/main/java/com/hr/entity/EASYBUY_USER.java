package com.hr.entity;

// 用户实体类
public class EASYBUY_USER {
	private String EU_USER_ID; // 用户ID
	private String EU_USER_NAME; // 用户名
	private String EU_PASSWORD; // 密码
	private String EU_SEX; // 性别
	private String EU_BIRTHDAY; // 生日
	private String EU_IDENTITY_CODE; // 身份证号
	private String EU_EMAIL; // 电子邮件
	private String EU_MOBILE; // 手机号码
	private String EU_ADDRESS; // 地址
	private int EU_STATUS; // 用户状态

	// 带参构造方法
	public EASYBUY_USER(String eUUSERID, String eUUSERNAME, String eUPASSWORD,
						String eUSEX, String eUBIRTHDAY, String eUIDENTITYCODE,
						String eUEMAIL, String eUMOBILE, String eUADDRESS, int eUSTATUS) {
		EU_USER_ID = eUUSERID;
		EU_USER_NAME = eUUSERNAME;
		EU_PASSWORD = eUPASSWORD;
		EU_SEX = eUSEX;
		EU_BIRTHDAY = eUBIRTHDAY;
		EU_IDENTITY_CODE = eUIDENTITYCODE;
		EU_EMAIL = eUEMAIL;
		EU_MOBILE = eUMOBILE;
		EU_ADDRESS = eUADDRESS;
		EU_STATUS = eUSTATUS;
	}

	// 获取用户ID
	public String getEU_USER_ID() {
		return EU_USER_ID;
	}

	// 设置用户ID
	public void setEU_USER_ID(String eUUSERID) {
		EU_USER_ID = eUUSERID;
	}

	// 获取用户名
	public String getEU_USER_NAME() {
		return EU_USER_NAME;
	}

	// 设置用户名
	public void setEU_USER_NAME(String eUUSERNAME) {
		EU_USER_NAME = eUUSERNAME;
	}

	// 获取密码
	public String getEU_PASSWORD() {
		return EU_PASSWORD;
	}

	// 设置密码
	public void setEU_PASSWORD(String eUPASSWORD) {
		EU_PASSWORD = eUPASSWORD;
	}

	// 获取性别
	public String getEU_SEX() {
		return EU_SEX;
	}

	// 设置性别
	public void setEU_SEX(String eUSEX) {
		EU_SEX = eUSEX;
	}

	// 获取生日
	public String getEU_BIRTHDAY() {
		return EU_BIRTHDAY;
	}

	// 设置生日
	public void setEU_BIRTHDAY(String eUBIRTHDAY) {
		EU_BIRTHDAY = eUBIRTHDAY;
	}

	// 获取身份证号
	public String getEU_IDENTITY_CODE() {
		return EU_IDENTITY_CODE;
	}

	// 设置身份证号
	public void setEU_IDENTITY_CODE(String eUIDENTITYCODE) {
		EU_IDENTITY_CODE = eUIDENTITYCODE;
	}

	// 获取电子邮件
	public String getEU_EMAIL() {
		return EU_EMAIL;
	}

	// 设置电子邮件
	public void setEU_EMAIL(String eUEMAIL) {
		EU_EMAIL = eUEMAIL;
	}

	// 获取手机号码
	public String getEU_MOBILE() {
		return EU_MOBILE;
	}

	// 设置手机号码
	public void setEU_MOBILE(String eUMOBILE) {
		EU_MOBILE = eUMOBILE;
	}

	// 获取地址
	public String getEU_ADDRESS() {
		return EU_ADDRESS;
	}

	// 设置地址
	public void setEU_ADDRESS(String eUADDRESS) {
		EU_ADDRESS = eUADDRESS;
	}

	// 获取用户状态
	public int getEU_STATUS() {
		return EU_STATUS;
	}

	// 设置用户状态
	public void setEU_STATUS(int eUSTATUS) {
		EU_STATUS = eUSTATUS;
	}
}
